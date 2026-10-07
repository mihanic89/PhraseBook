package xyz.yapapa.phrasebook;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Буквы и числа. Буквы — алфавит изучаемого языка, нажатие читает букву на нём.
 * Числа: нажатие читает число на родном языке, долгое нажатие — на изучаемом.
 */
public class CharAdapter extends RecyclerView.Adapter<CharAdapter.ViewHolder> {

    private final List<String> data;
    private final TTSListener tts;
    private final boolean translationOnly;

    static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textChar;

        ViewHolder(View itemView) {
            super(itemView);
            textChar = itemView.findViewById(R.id.textChar);
        }
    }

    /**
     * @param translationOnly символы изучаемого языка (алфавит): читаются только его голосом
     */
    CharAdapter(List<String> data, TTSListener tts, boolean translationOnly) {
        this.data = data;
        this.tts = tts;
        this.translationOnly = translationOnly;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.char_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final String text = data.get(position);
        holder.textChar.setText(text);
        if (translationOnly) {
            holder.textChar.setOnClickListener(v -> tts.speakTranslate(text));
            holder.textChar.setOnLongClickListener(null);
            holder.textChar.setLongClickable(false);
        } else {
            holder.textChar.setOnClickListener(v -> tts.speakDefault(text));
            holder.textChar.setOnLongClickListener(v -> {
                tts.speakTranslate(text);
                return true;
            });
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
