package xyz.yapapa.phrasebook;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.target.Target;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Misha on 09.01.2018.
 */

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {

    private final ArrayList<Phrase> mDataSet;
    private final int screenWidth;
    private Context context;


    private  TTSListener ttsListener;
    private final StorageReference mStorageRef= FirebaseStorage.getInstance().getReferenceFromUrl("gs://phrasebook-c5065.appspot.com");

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textTranslate;
        private final TextView textDefault;

        public final ImageView imageView;


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

    public WordAdapter( ArrayList<Phrase> dataSet, int screenWidth, Context context) {

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
        GlideApp.with(context).clear(holder.getImageView());
       // Toast toast = Toast.makeText(context,
      //          "очищен" + holder.getImageView(), Toast.LENGTH_SHORT);
      //  toast.show();
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        //holder.getTextView().setText(R.string.app_name);
        holder.getTextDefault().setText(mDataSet.get(position).getField());

        //holder.getTextView().setText(mDataSet.get(position).getField());

        try {
            holder.getTextTranslate().setText(getStringByLocal(mDataSet.get(position).getField(), mDataSet.get(position).getTranslateLanguage()));
        }
        catch (Exception e){
            holder.getTextTranslate().setText(R.string.error);
        }
        //Toast toast = Toast.makeText(context,
        //        "создан" + (int) screenWidth, Toast.LENGTH_SHORT);
        //toast.show();
        //Log.v("Glide", "создан= " +getStringById(mDataSet.get(position).getField())+ " " + position);
       // GlideSingleton.getGlide(context)




        GlideApp.with(context)
               // .asDrawable()
               // .load(mStorageRef.child(mDataSet.get(position).getImage()))
                .load(mStorageRef.child(mDataSet.get(position).getImage()))
                //.load(internetUrl)
                //.skipMemoryCache(true)
                .override((int)screenWidth, Target.SIZE_ORIGINAL)
                .fitCenter()
               // .thumbnail()
                 .error(R.mipmap.ic_launcher)
                .placeholder(new ColorDrawable(Color.GRAY))
               //.placeholder(R.mipmap.placeholder)
               // .transition(withCrossFade(700))
                .into(holder.getImageView());


        holder.getImageView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ttsListener.speakTranslate(getStringByLocal(
                        mDataSet.get(position).getField(),
                        mDataSet.get(position).getTranslateLanguage()));
            }

        });

        holder.getTextTranslate().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ttsListener.speakTranslate(getStringByLocal(
                        mDataSet.get(position).getField(),
                        mDataSet.get(position).getTranslateLanguage()));
            }

        });

        holder.getTextDefault().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ttsListener.speakDefault(getStringById(
                        mDataSet.get(position).getField())

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
