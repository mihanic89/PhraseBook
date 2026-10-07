package xyz.yapapa.phrasebook;

import android.content.Context;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/**
 * Одна вкладка: сетка карточек категории. В аргументах только номер категории и языки,
 * сами данные берутся из {@link DataModel}.
 */
public class CategoryFragment extends Fragment {

    private static final String ARG_CATEGORY = "category";
    private static final String ARG_ORIGINAL = "original";
    private static final String ARG_TRANSLATION = "translation";

    private WordAdapter wordAdapter;
    private ConnectivityManager.NetworkCallback networkCallback;

    static CategoryFragment newInstance(Category category, String originalLanguage, String translationLanguage) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_CATEGORY, category.ordinal());
        args.putString(ARG_ORIGINAL, originalLanguage);
        args.putString(ARG_TRANSLATION, translationLanguage);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_tabbed, container, false);
        RecyclerView recyclerView = root.findViewById(R.id.recyclerView);

        Bundle args = requireArguments();
        Category category = Category.values()[args.getInt(ARG_CATEGORY)];
        String original = args.getString(ARG_ORIGINAL, "en");
        String translation = args.getString(ARG_TRANSLATION, "en");

        TTSListener tts = (TTSListener) requireActivity();
        LocalizedStrings strings = new LocalizedStrings(requireContext(), original, translation);

        boolean largeScreen = (getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
        int spanCount;

        switch (category.kind) {
            case CHARS:
                spanCount = largeScreen ? 5 : 3;
                recyclerView.setAdapter(category == Category.NUMBERS
                        ? new CharAdapter(DataModel.numbers(), tts, false)
                        : new CharAdapter(DataModel.alphabet(translation), tts, true));
                break;
            case COLORS:
                spanCount = largeScreen ? 3 : 2;
                recyclerView.setAdapter(new ColorAdapter(DataModel.phrases(category), strings, tts));
                break;
            case FLAGS:
                spanCount = largeScreen ? 3 : 2;
                recyclerView.setAdapter(new FlagAdapter(DataModel.phrases(category), strings, tts));
                recyclerView.setItemViewCacheSize(0);
                recyclerView.getRecycledViewPool().setMaxRecycledViews(0, spanCount * 5);
                break;
            default:
                spanCount = largeScreen ? 3 : 2;
                int columnWidth = getResources().getDisplayMetrics().widthPixels / spanCount;
                wordAdapter = new WordAdapter(DataModel.phrases(category), columnWidth, strings, tts,
                        GlideApp.with(this));
                recyclerView.setAdapter(wordAdapter);
                recyclerView.setItemViewCacheSize(0);
                recyclerView.getRecycledViewPool().setMaxRecycledViews(0, spanCount * 4);
                break;
        }

        recyclerView.setLayoutManager(
                new StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.VERTICAL));
        return root;
    }

    @Override
    public void onDestroyView() {
        wordAdapter = null;
        super.onDestroyView();
    }

    /** Пока вкладка видна, при появлении сети повторяем загрузку не загрузившихся картинок. */
    @Override
    public void onStart() {
        super.onStart();
        if (wordAdapter == null) return;
        ConnectivityManager cm = (ConnectivityManager) requireContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm == null) return;
        networkCallback = new ConnectivityManager.NetworkCallback() {
            @Override
            public void onAvailable(@NonNull Network network) {
                View view = getView();
                if (view != null) {
                    view.post(() -> {
                        if (wordAdapter != null) wordAdapter.retryFailedLoads();
                    });
                }
            }
        };
        try {
            cm.registerDefaultNetworkCallback(networkCallback);
        } catch (RuntimeException e) {
            networkCallback = null;
        }
    }

    @Override
    public void onStop() {
        if (networkCallback != null) {
            ConnectivityManager cm = (ConnectivityManager) requireContext()
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            if (cm != null) {
                try {
                    cm.unregisterNetworkCallback(networkCallback);
                } catch (RuntimeException ignored) {
                    // колбэк уже снят
                }
            }
            networkCallback = null;
        }
        super.onStop();
    }
}
