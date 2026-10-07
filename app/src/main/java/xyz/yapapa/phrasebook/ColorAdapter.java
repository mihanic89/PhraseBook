package xyz.yapapa.phrasebook;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Карточки цветов: цветная плашка и подписи на двух языках.
 */
public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ViewHolder> {

    private final List<Phrase> data;
    private final LocalizedStrings strings;
    private final TTSListener tts;

    static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageColor;
        final TextView textTranslate;
        final TextView textDefault;

        ViewHolder(View itemView) {
            super(itemView);
            imageColor = itemView.findViewById(R.id.colorImage);
            textTranslate = itemView.findViewById(R.id.colorTextTranslate);
            textDefault = itemView.findViewById(R.id.colorTextDefault);
        }
    }

    ColorAdapter(List<Phrase> data, LocalizedStrings strings, TTSListener tts) {
        this.data = data;
        this.strings = strings;
        this.tts = tts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.color_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Phrase color = data.get(position);
        final String original = strings.original(color.getField());
        final String translation = strings.translation(color.getField());

        holder.textDefault.setText(original);
        holder.textTranslate.setText(translation);
        holder.imageColor.setImageResource(color.getColor());
        holder.imageColor.setContentDescription(original);

        holder.imageColor.setOnClickListener(v -> tts.speakDefault(original));
        holder.textDefault.setOnClickListener(v -> tts.speakDefault(original));
        holder.textTranslate.setOnClickListener(v -> tts.speakTranslate(translation));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
