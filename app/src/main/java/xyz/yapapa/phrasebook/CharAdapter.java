package xyz.yapapa.phrasebook;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Misha on 09.01.2018.
 */

public class CharAdapter extends RecyclerView.Adapter<CharAdapter.ViewHolder> {

    private  ArrayList<String> mDataSet;

    private TTSListener ttsListener;

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textChar;




        public ViewHolder(View itemView) {
            super(itemView);

            textChar = itemView.findViewById(R.id.textChar);




        }

        public TextView getTextChar() {
            return textChar;
        }



    }

    public CharAdapter(ArrayList<String> dataSet) {
        mDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.char_item, parent, false);
        Context context = parent.getContext();
        if (ttsListener==null){
            ttsListener = (TTSListener) context;}
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,  int position1) {
       // final int position = position1;

        final String char1 = mDataSet.get(position1);
        //holder.getTextView().setText(R.string.app_name);
        holder.getTextChar().setText(char1);


        holder.getTextChar().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ttsListener.speakDefault(char1);
            }

        });



        holder.getTextChar().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ttsListener.speakTranslate(char1);
                return true;
            }
        });


        //holder.getTextView().setText(mDataSet.get(position).getField());
        //holder.getTextTranslate().setText(getStringByLocal(mDataSet.get(position).getField(),mDataSet.get(position).getTranslateLanguage()));
       // holder.getImageView().setImageResource(mDataSet.get(position).getImage());
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





    @Override
    public int getItemCount() {
        return mDataSet.size();
    }




}
