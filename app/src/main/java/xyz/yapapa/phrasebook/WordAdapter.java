package xyz.yapapa.phrasebook;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Misha on 09.01.2018.
 */

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {

    private final ArrayList<Phrase> mDataSet;
    private Context context;
    private GlideRequests glide;
    private  TTSListener ttsListener;
    private final StorageReference mStorageRef= FirebaseStorage.getInstance().getReferenceFromUrl("gs://phrasebook-c5065.appspot.com");

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textTranslate;
        private final TextView textDefault;

        private final ImageView imageView;
        public Context context;

        public ViewHolder(View itemView) {
            super(itemView);

            textTranslate = itemView.findViewById(R.id.textTranslate);
            textDefault = itemView.findViewById(R.id.textDefault);
            imageView = itemView.findViewById(R.id.imageView);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ttsListener.speakTranslate(getStringByLocal(
                            mDataSet.get(getAdapterPosition()).getField(),
                            mDataSet.get(getAdapterPosition()).getTranslateLanguage()));
                }

            });
            textDefault.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ttsListener.speakDefault(getStringById(
                            mDataSet.get(getAdapterPosition()).getField())

                    );
                }

            });
        }

        public TextView getTextTranslate() {
            return textTranslate;
        }
        public TextView getTextDefault() {
            return textDefault;
        }
        public ImageView getImageView() {
            return imageView;
        }

        public void setContext (Context context) {
            this.context=context;
        }
    }

    public WordAdapter( ArrayList<Phrase> dataSet) {

        mDataSet = dataSet;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.word_item, parent, false);
        context = parent.getContext();
        if (ttsListener==null){
        ttsListener = (TTSListener)context;}

        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        //holder.getTextView().setText(R.string.app_name);
        holder.getTextDefault().setText(mDataSet.get(position).getField());

        //holder.getTextView().setText(mDataSet.get(position).getField());
        holder.getTextTranslate().setText(getStringByLocal(mDataSet.get(position).getField(),mDataSet.get(position).getTranslateLanguage()));


        GlideSingleton.getGlide(context)
        //GlideApp.with(context)

                .load(mStorageRef.child("1233.jpg"))
                //.load(internetUrl)
                .fitCenter()
                .override(200)
                .placeholder(new ColorDrawable(Color.GRAY))

                .into(holder.getImageView());


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

    private String getStringById(int id) {

        return context.getResources().getString(id);
    }

    private String getStringByLocal(int id, String locale) {
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        configuration.setLocale(new Locale(locale));
        return context.createConfigurationContext(configuration).getResources().getString(id);
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }




}