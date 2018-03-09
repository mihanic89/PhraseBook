package xyz.yapapa.phrasebook;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Misha on 09.01.2018.
 */

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ViewHolder> {

    private ArrayList<Phrase> mDataSet;
    private Context context;
    private TTSListener ttsListener;

    public class ViewHolder extends RecyclerView.ViewHolder {
        private  ImageView imageColor;
        private  TextView imageTextTranslate, imageTextDefault;



        public ViewHolder(View itemView) {


            super(itemView);

            imageColor = itemView.findViewById(R.id.colorImage);
            imageTextTranslate  = itemView.findViewById(R.id.colorTextTranslate);
            imageTextDefault  = itemView.findViewById(R.id.colorTextDefault);




        }

        public ImageView getImageColor() {
            return imageColor;
        }
        public TextView getImageTextTranslate() {
            return imageTextTranslate;
        }
        public TextView getImageTextDefault() {
            return imageTextDefault;
        }


    }

    public ColorAdapter(ArrayList<Phrase> dataSet) {
        mDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.color_item, parent, false);
        context = parent.getContext();
        if (ttsListener==null){
            ttsListener = (TTSListener)context;}
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position1) {
        //final int position = position1;
        final Phrase color = mDataSet.get(position1);
        //holder.getTextView().setText(R.string.app_name);
        //holder.getTextColor().setText("C");
        //holder.getTextColor().setTextColor(mDataSet.get(position));
        //holder.getTextColor().setBackground(mDataSet.get(position));
        //holder.getTextColor().setBackgroundColor(mDataSet.get(position));
        //holder.getTextView().setText(mDataSet.get(position).getField());
        //holder.getTextTranslate().setText(getStringByLocal(mDataSet.get(position).getField(),mDataSet.get(position).getTranslateLanguage()));
        holder.getImageTextDefault().setText(mDataSet.get(holder.getAdapterPosition()).getField());
        holder.getImageTextTranslate().setText(getStringByLocal(mDataSet.get(holder.getAdapterPosition()).getField(),mDataSet.get(holder.getAdapterPosition()).getTranslateLanguage()));
        holder.getImageColor().setImageResource(mDataSet.get(holder.getAdapterPosition()).getColor());

        holder.getImageColor().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ttsListener.speakTranslate(getStringByLocal(
                        color.getField(),color.getTranslateLanguage()));
            }

        });

        holder.getImageTextTranslate().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ttsListener.speakTranslate(getStringByLocal(
                        color.getField(),
                        color.getTranslateLanguage()));
            }

        });

        holder.getImageTextDefault().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ttsListener.speakDefault(getStringById(
                        color.getField())

                );
            }

        });


        // Define click listener for the ViewHolder's View.

       /* holder.getTextTranslate().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ttsListener.speak(getStringByLocal(mDataSet.get(position).getField(),mDataSet.get(position).getTranslateLanguage()));
            }

        });

        holder.getImageView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ttsListener.speak(getStringByLocal(mDataSet.get(position).getField(),mDataSet.get(position).getTranslateLanguage()));
            }

        });

        holder.getTextDefault().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tts= new TextToSpeech(context, new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status == TextToSpeech.SUCCESS){
                            int result = tts.setLanguage(new Locale(mDataSet.get(position).getDefaultLanguage(),""));
                            String toSpeak = context.getResources().getString(mDataSet.get(position).getField());
                            String utteranceId = this.hashCode() + "";

                            Bundle params = new Bundle();
                            params.putString(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "");
                            tts.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, params, utteranceId);
                        }else{
                            Toast.makeText(context, "Not Supported in your Device", Toast.LENGTH_SHORT).show();
                        }

                    }


                });
            }
        });



        holder.getTextTranslate().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tts= new TextToSpeech(context, new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status == TextToSpeech.SUCCESS){
                            int result = tts.setLanguage(new Locale(mDataSet.get(position).getTranslateLanguage(),""));
                            String toSpeak = getStringByLocal(mDataSet.get(position).getField(), mDataSet.get(position).getTranslateLanguage());
                            String utteranceId = this.hashCode() + "";

                            Bundle params = new Bundle();
                            params.putString(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "");
                            tts.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, params, utteranceId);
                        }else{
                            Toast.makeText(context, "Not Supported in your Device", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        */
    }



    private String getStringByLocal(int id, String locale) {
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        configuration.setLocale(new Locale(locale));
        return context.createConfigurationContext(configuration).getResources().getString(id);
    }

    private String getStringById(int id) {

        return context.getResources().getString(id);
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }




}
