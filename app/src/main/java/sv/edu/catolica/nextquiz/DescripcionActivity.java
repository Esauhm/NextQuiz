package sv.edu.catolica.nextquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class DescripcionActivity extends AppCompatActivity {

    private Button repetir, regresar;

    ImageView imagen;

    Drawable drawable;

    TextView nombre, descrpicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion);

        regresar = findViewById(R.id.btn_regresar);
        repetir = findViewById(R.id.btn_repetir);
        imagen = findViewById(R.id.img_card);
        nombre = findViewById(R.id.txt_nombre);
        descrpicion = findViewById(R.id.txt_descripcion);

        String Cuestionario = getIntent().getStringExtra("cst");
        int Vimagen = getIntent().getIntExtra("img", 0);


        try {
            switch (Cuestionario) {
                //Cuestionario 1
                case "Questionario1":
                    if (Vimagen == 1) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.d1);
                        imagen.setImageDrawable(drawable);

                        nombre.setText("Goku");
                        descrpicion.setText("\n" +
                                "Eres Goku. Eres enérgico, optimista y leal. Defiendes a tus seres queridos. Eres determinado y valiente, un líder inspirador. Buscas superar tus límites. Eres generoso y divertido, amante de la aventura. Tu personalidad inspira a otros. ¡Aprovecha tus habilidades y vive tus propias aventuras como Goku!");
                    } else if (Vimagen == 2) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.d2);
                        imagen.setImageDrawable(drawable);

                        nombre.setText("Bills");
                        descrpicion.setText("\n" +
                                "Bills: Muy poderoso, excéntrico y glotón. Es el Dios de la Destrucción del Universo 7. Aunque temido, su comportamiento puede ser impredecible y a veces sorprendentemente amigable. Si te sale Bills, ¡prepárate para grandes aventuras cósmicas!");
                    } else if (Vimagen == 3) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.d3);
                        imagen.setImageDrawable(drawable);

                        nombre.setText("Majin Buu");
                        descrpicion.setText("\n" +
                                "Majin Buu: Un ser rosado y regordete con personalidad infantil. Es poderoso y capaz de absorber a sus enemigos. A veces actúa de manera inocente y juguetona, pero también puede ser extremadamente destructivo. ¡Si te sale Majin Buu, prepárate para un caos encantador!");
                    } else if (Vimagen == 4) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.d4);
                        imagen.setImageDrawable(drawable);

                        nombre.setText("Gohan");
                        descrpicion.setText("Gohan: Un guerrero con un corazón amable y valiente. Es hijo de Goku y posee un gran potencial oculto. Aunque en ocasiones duda de su fuerza, se convierte en un formidable defensor de la justicia. ¡Si te sale Gohan, serás un héroe con un poder asombroso!");
                    } else if (Vimagen == 5) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.d5);
                        imagen.setImageDrawable(drawable);

                        nombre.setText("Freezer");
                        descrpicion.setText("Freezer: Un tirano galáctico de naturaleza despiadada. Es el líder del Ejército de Freezer y hará cualquier cosa para lograr sus objetivos. Su crueldad y poder destructivo lo convierten en un formidable enemigo. ¡Si te sale Freezer, serás un villano temido y respetado en el universo!");
                    } else if (Vimagen == 6) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.d6);
                        imagen.setImageDrawable(drawable);

                        nombre.setText("Kaiosama");
                        descrpicion.setText("Kaiosama: Un ser divino y alegre, eres el Kaio encargado de supervisar la Galaxia Norte. Con tu personalidad enérgica y humorístico, traes diversión y entretenimiento a aquellos que te rodean. Tu sabiduría y habilidades de entrenamiento hacen de ti un mentor valorado por los guerreros. ¡Si te salió Kaiosama, eres un verdadero espíritu libre!");
                    } else if (Vimagen == 7) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.d7);
                        imagen.setImageDrawable(drawable);

                        nombre.setText("Krillin");
                        descrpicion.setText("Krillin: Valiente y leal, destacas por tu coraje y determinación. Aunque temes en momentos difíciles, proteges a tus seres queridos. Tu apariencia pequeña no refleja tu valía. Con ingenio y habilidad, eres un valioso aliado en la lucha contra el mal. Si eres Krillin, eres un héroe intrépido.");
                    } else if (Vimagen == 8) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.d8);
                        imagen.setImageDrawable(drawable);

                        nombre.setText("Maestro Roshi");
                        descrpicion.setText("Maestro Roshi: Eres sabio y poderoso, un maestro legendario en artes marciales. Aunque a veces puedes ser algo pervertido, tu corazón noble y tu amor por tus estudiantes son inquebrantables. Tu estilo de vida relajado y tu sentido del humor hacen de ti una figura única y respetada en el mundo.");
                    } else if (Vimagen == 9) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.d9);
                        imagen.setImageDrawable(drawable);

                        nombre.setText("Vegeta");
                        descrpicion.setText("Vegeta: Eres un príncipe guerrero orgulloso y determinado. Buscas superar a Goku y demostrar tu poderío. Aunque inicialmente eras arrogante y frío, has desarrollado un lado más humano y protector. Tu sed de batalla y tu búsqueda constante de poder te hacen inigualable en la lucha.");
                    } else if (Vimagen == 10) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.d1);
                        imagen.setImageDrawable(drawable);

                        nombre.setText("Goku");
                        descrpicion.setText("\n" +
                                "Eres Goku. Eres enérgico, optimista y leal. Defiendes a tus seres queridos. Eres determinado y valiente, un líder inspirador. Buscas superar tus límites. Eres generoso y divertido, amante de la aventura. Tu personalidad inspira a otros. ¡Aprovecha tus habilidades y vive tus propias aventuras como Goku!");
                    } else {
                        System.out.println("Respuesta fuera de rango");
                    }
                    break;

                //Cuestionario 2
                case "Questionario2":
                    if (Vimagen == 1) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.unicornio_salvaje);
                        imagen.setImageDrawable(drawable);

                        nombre.setText("Unicornio Salvaje");
                        descrpicion.setText("¡Enhorabuena! Si obtuviste el resultado del unicornio salvaje en este test, eso significa que eres tan mágico y único como una mezcla de arcoíris y purpurina. Eres como el unicornio salvaje de las fiestas, siempre listo/a para animar el ambiente y llenar de alegría cualquier situación.");

                    } else if (Vimagen == 2) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.gatocornio);
                        imagen.setImageDrawable(drawable);

                        nombre.setText("GatoCornio");
                        descrpicion.setText("Como gaticornio, eres curioso y juguetón, siempre explorando nuevos lugares y descubriendo cosas fascinantes. Tu pelaje suave y tus ojos brillantes capturan la atención de todos a tu alrededor, y tu cuerno mágico te otorga un toque de encanto adicional.\n");
                    } else if (Vimagen == 3) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.pandicornio);
                        imagen.setImageDrawable(drawable);

                        nombre.setText("PandiCornio");
                        descrpicion.setText("Eres alguien cálido, amable y lleno de amor para compartir con los demás. Tu presencia es como un bálsamo para aquellos que te rodean, ya que contagias felicidad y generosidad. ");
                    } else if (Vimagen == 4) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.puercornio);
                        imagen.setImageDrawable(drawable);

                        nombre.setText("PuerCornio");
                        descrpicion.setText("Como puercornio, eres juguetón y travieso, siempre dispuesto a explorar nuevos lugares y probar nuevas experiencias. Tu aspecto encantador de cerdito y tu cuerno mágico te distinguen y te hacen destacar entre los demás.\n");
                    } else if (Vimagen == 5) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.unicornio_bebe);
                        imagen.setImageDrawable(drawable);

                        nombre.setText("Unicornio bebé");
                        descrpicion.setText("¡Oh, qué adorabilidad pura! Si obtuviste como resultado un unicornio bebé, ¡felicidades! Eres una persona llena de inocencia, ternura y una gran imaginación. Tu unicornio bebé es juguetón, curioso y siempre está buscando nuevas aventuras.");
                    } else if (Vimagen == 6) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.unicornio_estelar);
                        imagen.setImageDrawable(drawable);

                        nombre.setText("Unicornio Estelar");
                        descrpicion.setText("¡Felicitaciones, eres un unicornio estelar! ¡Eso significa que tienes un brillo interior tan deslumbrante que podrías hacer que las constelaciones se pongan celosas! Tu pelaje violeta brillante y tus poderes mágicos te convierten en el centro de atención en todas las fiestas cósmicas.");

                    } else if (Vimagen == 7) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.unicornio_salvaje);
                        imagen.setImageDrawable(drawable);

                        nombre.setText("Unicornio Salvaje");
                        descrpicion.setText("¡Enhorabuena! Si obtuviste el resultado del unicornio salvaje en este test, eso significa que eres tan mágico y único como una mezcla de arcoíris y purpurina. Eres como el unicornio salvaje de las fiestas, siempre listo/a para animar el ambiente y llenar de alegría cualquier situación.");

                    } else if (Vimagen == 8) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.pandicornio);
                        imagen.setImageDrawable(drawable);

                        nombre.setText("PandiCornio");
                        descrpicion.setText("Eres alguien cálido, amable y lleno de amor para compartir con los demás. Tu presencia es como un bálsamo para aquellos que te rodean, ya que contagias felicidad y generosidad. ");
                    } else if (Vimagen == 9) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.unicornio_bebe);
                        imagen.setImageDrawable(drawable);

                        nombre.setText("Unicornio bebé");
                        descrpicion.setText("¡Oh, qué adorabilidad pura! Si obtuviste como resultado un unicornio bebé, ¡felicidades! Eres una persona llena de inocencia, ternura y una gran imaginación. Tu unicornio bebé es juguetón, curioso y siempre está buscando nuevas aventuras.");
                    } else if (Vimagen == 10) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.gatocornio);
                        imagen.setImageDrawable(drawable);

                        nombre.setText("GatoCornio");
                        descrpicion.setText("Como gaticornio, eres curioso y juguetón, siempre explorando nuevos lugares y descubriendo cosas fascinantes. Tu pelaje suave y tus ojos brillantes capturan la atención de todos a tu alrededor, y tu cuerno mágico te otorga un toque de encanto adicional.\n");
                    } else {
                        System.out.println("Respuesta fuera de rango");
                    }
                    break;


                //Cuestionario 3
                case "Questionario3":
                    if (Vimagen == 1) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.p1);
                        imagen.setImageDrawable(drawable);

                        nombre.setText("Jazmin");
                        descrpicion.setText("Eres una persona valiente y decidida. No temes desafiar las expectativas y buscar tu propia libertad. Tienes un espíritu aventurero y anhelas explorar el mundo más allá de tus límites. ");

                    } else if (Vimagen == 2) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.p2);
                        imagen.setImageDrawable(drawable);

                        nombre.setText("Moana");
                        descrpicion.setText("Eres valiente, perseverante y conectada con la naturaleza. Tu espíritu aventurero y determinación te guían en busca de tu propósito. Tu curiosidad y amor por el océano te hacen única y valiosa.");
                    } else if (Vimagen == 3) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.p3);
                        imagen.setImageDrawable(drawable);

                        nombre.setText("Bella");
                        descrpicion.setText("Eres inteligente, curiosa y tienes un espíritu libre. Valoras la belleza interior y encuentras la alegría en la lectura y el conocimiento. Ves más allá de las apariencias y te enfocas en la bondad y el potencial de las personas. ");
                    } else if (Vimagen == 4) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.p4);
                        imagen.setImageDrawable(drawable);

                        nombre.setText("Blancanieves");
                        descrpicion.setText("Eres amable, inocente y generosa. Tu dulzura y carisma atraen a los demás. Siempre encuentras la belleza en todo y tienes una conexión especial con la naturaleza y los animales. ");
                    } else if (Vimagen == 5) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.p5);
                        imagen.setImageDrawable(drawable);

                        nombre.setText("Ariel");
                        descrpicion.setText("Curiosa y valiente, con una pasión por el mar. Dispuesta a arriesgarlo todo por sus sueños. Conexión profunda con la vida acuática. Determinada y luchadora. Su voz es su mayor fortaleza.");
                    } else if (Vimagen == 6) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.p6);
                        imagen.setImageDrawable(drawable);

                        nombre.setText("Rapunzel");
                        descrpicion.setText("Encantadora y llena de vitalidad, con una melena dorada y mágica. Curiosa y con un espíritu aventurero. Posee una creatividad desbordante y un corazón generoso. Descubre el mundo fuera de su torre y se empodera para buscar su libertad.");
                    } else if (Vimagen == 7) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.p7);
                        imagen.setImageDrawable(drawable);

                        nombre.setText("Anna");
                        descrpicion.setText("Joven valiente y leal, aventurera y optimista. Amor inquebrantable por Elsa, protectora de su familia. Corazón cálido y generoso.");
                    } else if (Vimagen == 8) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.p8);
                        imagen.setImageDrawable(drawable);

                        nombre.setText("Elsa");
                        descrpicion.setText("Reina poderosa con habilidades de hielo. Firme y decidida, pero también vulnerable. Descubre el poder del amor y la aceptación. Transforma el miedo en valentía. Bella voz y espíritu libre.");
                    } else if (Vimagen == 9) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.p9);
                        imagen.setImageDrawable(drawable);

                        nombre.setText("Tiana");
                        descrpicion.setText("Trabajadora y ambiciosa. Sueña con su propio restaurante. Fuerte y valiente. Apasionada por la cocina y la música. Cree en el trabajo duro y seguir los sueños. Encantadora y determinada.");
                    } else if (Vimagen == 10) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.p10);
                        imagen.setImageDrawable(drawable);

                        nombre.setText("Mulan");
                        descrpicion.setText("\n" +
                                "Mulan, valiente guerrera, se disfraza de hombre, lucha por su familia y honra. Coraje, lealtad, inspiración. Su espíritu indomable demuestra que el poder está en el interior. Una historia de fuerza y determinación. Mulan, símbolo de valentía.");
                    } else {
                        System.out.println("Respuestaa fuera de rango");
                    }
                    break;


                //Cuestionario 4
                case "Questionario4":
                    if (Vimagen == 1) {
                        drawable = getResources().getDrawable(R.drawable.c1);
                        imagen.setImageDrawable(drawable);

                        nombre.setText("Tacos");
                        descrpicion.setText("Eres Tacos, la explosión de sabores envuelta en una tortilla. Irresistible, versátil y siempre listo para deleitar, eres el favorito que nadie puede resistir. ¡Disfruta de tu deliciosa personalidad culinaria!");

                    } else if (Vimagen == 2) {
                        drawable = getResources().getDrawable(R.drawable.c2);
                        imagen.setImageDrawable(drawable);

                        nombre.setText("Pizza");
                        descrpicion.setText("\n" +
                                "Eres Pizza, una delicia circular con una base de masa crujiente, cubierta de sabrosa salsa, queso derretido y diversos ingredientes. ¡Siempre dejas a todos con ganas de más!");
                    } else if (Vimagen == 3) {
                        drawable = getResources().getDrawable(R.drawable.c3);
                        imagen.setImageDrawable(drawable);

                        nombre.setText("Hamburguesa");
                        descrpicion.setText("Eres Hamburguesa, una tentación irresistible. Jugosa, sabrosa y con capas de ingredientes deliciosos. ¡Satisfaces los antojos con cada mordisco!");
                    } else if (Vimagen == 4) {
                        drawable = getResources().getDrawable(R.drawable.c4);
                        imagen.setImageDrawable(drawable);

                        nombre.setText("Papas fritas");
                        descrpicion.setText("\n" +
                                "Eres un acompañamiento crujiente y sabroso. Te disfrutan en cada bocado, ya sea solas o con salsa. ¡Siempre agregas un toque de satisfacción a cualquier comida!");
                    } else if (Vimagen == 5) {
                        drawable = getResources().getDrawable(R.drawable.c5);
                        imagen.setImageDrawable(drawable);

                        nombre.setText("Hot Dog");
                        descrpicion.setText("\n" +
                                "Eres un Hot dog, la combinación perfecta de salchicha y pan. Un clásico de la comida rápida que nunca pasa de moda.");
                    } else if (Vimagen == 6) {
                        drawable = getResources().getDrawable(R.drawable.c6);
                        imagen.setImageDrawable(drawable);

                        nombre.setText("Sandwich");
                        descrpicion.setText("\n" +
                                "Eres el Sandwich, sabroso y versátil. Un bocadillo perfecto con infinitas combinaciones. Satisface cualquier antojo con su delicioso relleno y textura. Siempre una opción rápida y deliciosa.");
                    } else if (Vimagen == 7) {
                        drawable = getResources().getDrawable(R.drawable.c7);
                        imagen.setImageDrawable(drawable);

                        nombre.setText("Burrito");
                        descrpicion.setText("Eres una delicia envuelta en tortilla. Repleto de sabores y ingredientes, es una explosión de sabor en cada bocado. Versátil y satisfactorio, te adaptas a cualquier ocasión y siempre dejas un buen sabor de boca.");
                    } else if (Vimagen == 8) {
                        drawable = getResources().getDrawable(R.drawable.c1);
                        imagen.setImageDrawable(drawable);

                        nombre.setText("Tacos");
                        descrpicion.setText("Eres Tacos, la explosión de sabores envuelta en una tortilla. Irresistible, versátil y siempre listo para deleitar, eres el favorito que nadie puede resistir. ¡Disfruta de tu deliciosa personalidad culinaria!");
                    } else if (Vimagen == 9) {
                        drawable = getResources().getDrawable(R.drawable.c2);
                        imagen.setImageDrawable(drawable);

                        nombre.setText("Pizza");
                        descrpicion.setText("\n" +
                                "Eres Pizza, una delicia circular con una base de masa crujiente, cubierta de sabrosa salsa, queso derretido y diversos ingredientes. ¡Siempre dejas a todos con ganas de más!");
                    } else if (Vimagen == 10) {
                        drawable = getResources().getDrawable(R.drawable.c3);
                        imagen.setImageDrawable(drawable);

                        nombre.setText("hamburguesa");
                        descrpicion.setText("Eres Hamburguesa, una tentación irresistible. Jugosa, sabrosa y con capas de ingredientes deliciosos. ¡Satisfaces los antojos con cada mordisco!");
                    } else {
                        System.out.println("Respuestsa fuera de rango");
                    }
                    break;
            }


        }catch (Exception e){
            System.out.println("Respuesta fuera de rango");
        }

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DescripcionActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        repetir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DescripcionActivity.this, PreguntaActivity.class);
                intent.putExtra("set", Cuestionario);
                startActivity(intent);
                finish();
            }
        });


    }
}