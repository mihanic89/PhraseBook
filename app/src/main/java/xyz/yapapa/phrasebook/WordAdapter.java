package xyz.yapapa.phrasebook;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.signature.ObjectKey;

import java.util.List;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

/**
 * Карточки с картинкой: верхняя подпись на родном языке, нижняя на изучаемом.
 */
public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {

    /** Каталог с картинками карточек; имя файла берётся из {@link Phrase#getImage()}. */
    public static final String IMAGE_BASE_URL = "https://apps.mayak.net.ru/gifs2/";

    /** Версия набора картинок: часть ключа кэша, меняйте при замене файлов на сервере. */
    private static final int IMAGE_VERSION = 1;

    /** По умолчанию у Glide 2,5 с — на мобильной сети крупные файлы не успевают. */
    private static final int IMAGE_TIMEOUT_MS = 10000;

    private final List<Phrase> data;
    private final int imageSize;
    private final LocalizedStrings strings;
    private final TTSListener tts;
    private final GlideRequests glide;

    private boolean hasFailedLoads = false;

    static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textTranslate;
        final TextView textDefault;
        final ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView);
            textTranslate = itemView.findViewById(R.id.textTranslate);
            textDefault = itemView.findViewById(R.id.textDefault);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    /**
     * @param imageSize сторона, до которой Glide уменьшает картинку (ширина колонки в пикселях)
     */
    WordAdapter(List<Phrase> data, int imageSize, LocalizedStrings strings,
                TTSListener tts, GlideRequests glide) {
        this.data = data;
        this.imageSize = imageSize;
        this.strings = strings;
        this.tts = tts;
        this.glide = glide;
    }

    /** Перезагружает карточки, если часть картинок не загрузилась (например, не было сети). */
    void retryFailedLoads() {
        if (hasFailedLoads) {
            hasFailedLoads = false;
            notifyItemRangeChanged(0, getItemCount());
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.word_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onViewRecycled(@NonNull ViewHolder holder) {
        glide.clear(holder.imageView);
        holder.imageView.setImageDrawable(null);
        holder.textDefault.setText(null);
        holder.textTranslate.setText(null);
        holder.imageView.setOnClickListener(null);
        holder.textDefault.setOnClickListener(null);
        holder.textTranslate.setOnClickListener(null);
        super.onViewRecycled(holder);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Phrase word = data.get(position);
        final String original = strings.original(word.getField());
        final String translation = strings.translation(word.getField());

        holder.textDefault.setText(original);
        holder.textTranslate.setText(translation);
        holder.imageView.setContentDescription(original);

        glide.load(IMAGE_BASE_URL + word.getImage())
                // Glide не проверяет изменения файла на сервере: при замене картинок увеличьте IMAGE_VERSION
                .signature(new ObjectKey(IMAGE_VERSION))
                .set(HttpGlideUrlLoader.TIMEOUT, IMAGE_TIMEOUT_MS)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model,
                                                Target<Drawable> target, boolean isFirstResource) {
                        hasFailedLoads = true;
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model,
                                                   Target<Drawable> target, DataSource dataSource,
                                                   boolean isFirstResource) {
                        return false;
                    }
                })
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .priority(Priority.LOW)
                .override(imageSize)
                .fitCenter()
                .error(R.mipmap.ic_launcher)
                .placeholder(R.color.background)
                .transition(withCrossFade(700))
                .into(holder.imageView);

        holder.imageView.setOnClickListener(v -> tts.speakDefault(original));
        holder.textDefault.setOnClickListener(v -> tts.speakDefault(original));
        holder.textTranslate.setOnClickListener(v -> tts.speakTranslate(translation));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
