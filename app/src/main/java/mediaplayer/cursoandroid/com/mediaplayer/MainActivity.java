package mediaplayer.cursoandroid.com.mediaplayer;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private Button botaoTocar;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoTocar = findViewById(R.id.botaoTocarId);

        //a "musica.mp3" se encontra na pasta raw
        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.musica);

        //decide a acao que fará ao clicar no botao
        botaoTocar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    pausarMusica();
                }
                else{
                    tocarMusica();
                }
            }
        });
    }

    private void tocarMusica(){
        if (mediaPlayer != null){
            mediaPlayer.start();
            //se o botão for clicado para "Tocar", o titulo do botão irá mudar para "Pausar" enquanto a musica toca
            botaoTocar.setText("Pausar");
        }
    }



    private void pausarMusica(){
        if (mediaPlayer != null){
            mediaPlayer.pause();
            //se o botão for clicado para "Pausar", o titulo do botão irá mudar para "Tocar" enquanto a musica toca
            botaoTocar.setText("Tocar");
        }
    }

    //garante que os recursos de memoria sejam liberados
    @Override
    public boolean isDestroyed() {

        if (mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        return super.isDestroyed();
    }
}
