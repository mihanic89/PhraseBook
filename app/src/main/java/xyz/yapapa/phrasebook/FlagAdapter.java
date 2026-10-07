package xyz.yapapa.phrasebook;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * География: страна или регион, эмодзи-флаг и подписи на двух языках.
 */
public class FlagAdapter extends RecyclerView.Adapter<FlagAdapter.ViewHolder> {

    private final List<Phrase> data;
    private final LocalizedStrings strings;
    private final TTSListener tts;

    static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textTranslate;
        final TextView textDefault;
        final TextView flagView;

        ViewHolder(View itemView) {
            super(itemView);
            textTranslate = itemView.findViewById(R.id.textTranslate);
            textDefault = itemView.findViewById(R.id.textDefault);
            flagView = itemView.findViewById(R.id.flagView);
        }
    }

    FlagAdapter(List<Phrase> data, LocalizedStrings strings, TTSListener tts) {
        this.data = data;
        this.strings = strings;
        this.tts = tts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.flag_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Phrase flag = data.get(position);
        final String original = strings.original(flag.getField());
        final String translation = strings.translation(flag.getField());

        holder.textDefault.setText(original);
        holder.textTranslate.setText(translation);
        holder.flagView.setText(flag.getImage());
        holder.flagView.setContentDescription(original);

        holder.flagView.setOnClickListener(v -> tts.speakDefault(original));
        holder.textDefault.setOnClickListener(v -> tts.speakDefault(original));
        holder.textTranslate.setOnClickListener(v -> tts.speakTranslate(translation));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
