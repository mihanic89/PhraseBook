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

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Misha on 09.01.2018.
 */

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {

    private ArrayList<Phrase> mDataSet;
    private final int screenWidth;
    private Context context;
    private GlideRequests glideRequests;

    private  TTSListener ttsListener;
    private final StorageReference mStorageRef= FirebaseStorage.getInstance().getReferenceFromUrl("gs://phrasebook-c5065.appspot.com");

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textTranslate;
        private TextView textDefault;

        public ImageView imageView;


        public ViewHolder(View itemView) {
            super(itemView);

            textTranslate = itemView.findViewById(R.id.textTranslate);
            textDefault = itemView.findViewById(R.id.textDefault);
            imageView = itemView.findViewById(R.id.imageView);


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


    }

    public WordAdapter( ArrayList<Phrase> dataSet, int screenWidth, Context context, GlideRequests glideRequests ) {
        this.glideRequests = glideRequests;
        this.screenWidth = screenWidth;
        mDataSet = dataSet;
        this.context = context;
        if (ttsListener==null){
        ttsListener = (TTSListener)context;}

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.word_item, parent, false);
        //if (context==null){
       // context = parent.getContext().getApplicationContext();}


        return new ViewHolder(v);

    }

    @Override
    public void onViewRecycled (ViewHolder holder){


        glideRequests.clear(holder.getImageView());
        holder.getImageView().setImageBitmap(null);
        holder.getTextDefault().setOnClickListener(null);
        holder.getTextTranslate().setOnClickListener(null);
        super.onViewRecycled(holder);
       // Toast toast = Toast.makeText(context,
      //          "очищен" + holder.getImageView(), Toast.LENGTH_SHORT);
      //  toast.show();
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position1) {
        //holder.getTextView().setText(R.string.app_name);
        //final int position = position1;
        final Phrase word = mDataSet.get(position1);
        holder.getTextDefault().setText(word.getField());

        //holder.getTextView().setText(mDataSet.get(position).getField());

        try {
            holder.getTextTranslate().setText(getStringByLocal(word.getField(),
                    word.getTranslateLanguage()));
        }
        catch (Exception e){
            holder.getTextTranslate().setText(R.string.error);
        }
        //Toast toast = Toast.makeText(context,
        //        "создан" + (int) screenWidth, Toast.LENGTH_SHORT);
        //toast.show();
        //Log.v("Glide", "создан= " +getStringById(mDataSet.get(position).getField())+ " " + position);
       // GlideSingleton.getGlide(context)




        glideRequests
               // .asDrawable()
               // .load(mStorageRef.child(mDataSet.get(position).getImage()))
                .load(mStorageRef.child(word.getImage()))
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .priority(Priority.LOW)
                //.load(internetUrl)
                //.skipMemoryCache(true)
                .override((int)screenWidth)
                .fitCenter()
               // .thumbnail()
                 .error(R.mipmap.ic_launcher)
                .placeholder(new ColorDrawable(context.getResources().getColor( R.color.background)))
               //.placeholder(R.mipmap.placeholder)
                .transition(withCrossFade(700))
                .into(holder.getImageView());


        holder.getImageView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ttsListener.speakTranslate(getStringByLocal(
                        word.getField(),
                        word.getTranslateLanguage()));
            }

        });

        holder.getTextTranslate().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ttsListener.speakTranslate(getStringByLocal(
                        word.getField(),
                        word.getTranslateLanguage()));
            }

        });

        holder.textDefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ttsListener.speakDefault(getStringById(
                        word.getField())

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
