import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

//OISEAU transition

public class Main extends Application {
    public static void main(String[] args) { launch(args);}

    @Override
    public void start(Stage primaryStage) throws Exception {
        //fenêtre
        primaryStage.setWidth(800);
        primaryStage.setHeight(400);
        primaryStage.setTitle("Dessin!");
        primaryStage.setResizable(false);

        //textes
        Font f = Font.font("Calibri", 40);
        Text nuit = new Text(550,300, "Nuit");
        nuit.setFill(Color.WHITE);
        nuit.setFont(f);
        Text jour = new Text(150,300, "Jour");
        jour.setFill(Color.BLACK);
        jour.setFont(f);

        //rectangle noir
        Rectangle rectNoir = new Rectangle(400, 0, 800,400);
        rectNoir.setFill(Color.BLACK);

        //rectangle gris
        Rectangle rectGris = new Rectangle(0,0,400,400);
        rectGris.setFill(Color.LIGHTGREY);

        //cercle jaune
        Circle soleil = new Circle(300, 75,35);
        soleil.setFill(Color.YELLOW);
        soleil.setStrokeWidth(5);
        soleil.setStroke(Color.LIGHTGREY);
        FillTransition trans = new FillTransition(
                Duration.seconds(2), soleil);
        trans.setToValue(Color.ORANGE);
        trans.setCycleCount(Timeline.INDEFINITE);
        trans.setAutoReverse(true);
        trans.play();

        Line rayon = new Line(225,75, 380,75);
        rayon.setStroke(Color.ORANGE);

        Line rayon3 = new Line(300,5, 300, 75);
        rayon3.setStroke(Color.ORANGE);

        Line rayon4 = new Line(300, 75, 300, 150);
        rayon4.setStroke(Color.ORANGE);

        Line rayon5 = new Line(250, 35, 350, 115);
        rayon5.setStroke(Color.ORANGE);

        Line rayon6 = new Line(250, 115, 350, 35);
        rayon6.setStroke(Color.ORANGE);

        Group rayonJour = new Group(rayon, rayon3, rayon4, rayon5, rayon6);

        RotateTransition transition = new RotateTransition(
                Duration.seconds(5), rayonJour);
        transition.setByAngle(360);
        transition.setCycleCount(Timeline.INDEFINITE);
        transition.setInterpolator(Interpolator.LINEAR);
        transition.play();


        // cercle noir
        Circle lune = new Circle(725,75, 35);
        Stop[] stops = new Stop[]{
                new Stop(0, Color.GREY),
                //new Stop(0.3, Color.DARKGREY),
                new Stop(1, Color.BLACK),
        };
        LinearGradient gradient = new LinearGradient(
                0,0,
                1,1,
                true,
                CycleMethod.NO_CYCLE,
                stops);
        lune.setFill(gradient);

        //maison jour
        Polygon triangle = new Polygon(180,140, 230,200, 130,200);
        triangle.setFill(Color.BROWN);

        Rectangle rectangle = new Rectangle(135,200, 90,50);
        rectangle.setFill(Color.BEIGE);

        Rectangle rectangle3 = new Rectangle(185, 210, 30, 20);
        rectangle3.setFill(Color.AQUA);
        rectangle3.setStroke(Color.BLUE);
        Line ligne = new Line(200,210, 200, 230);
        ligne.setFill(Color.BLUE);
        Line ligne2 = new Line(185, 220, 215, 220);

        Rectangle rectangle5 = new Rectangle(150, 220, 20, 30);
        rectangle5.setFill(Color.SADDLEBROWN);

        Circle porte2 = new Circle(165, 235, 4);
        porte2.setFill(Color.YELLOWGREEN);

        DropShadow ds = new DropShadow(20,-10,10, Color.GREY);
        rectangle.setEffect(ds);

        //maison nuit
        Polygon  triangle2 = new Polygon(580,140, 630,200, 530, 200);
        triangle2.setFill(Color.BROWN);

        Rectangle rectangle2 = new Rectangle(535, 200, 90,50);
        rectangle2.setFill(Color.BEIGE);

        Rectangle rectangle4 = new Rectangle(585,210, 30,20);
        rectangle4.setFill(Color.AQUA);
        rectangle4.setStroke(Color.BLUE);
        Line ligne3 = new Line(600,210, 600, 230);
        ligne3.setFill(Color.BLUE);
        Line ligne4 = new Line(585, 220, 615, 220);

        Rectangle rectangle6 = new Rectangle(550, 220, 20, 30);
        rectangle6.setFill(Color.SADDLEBROWN);

        Circle porte1 = new Circle(565, 235, 4);
        porte1.setFill(Color.YELLOWGREEN);

        //oiseaux
        QuadCurve oiseau1 = new QuadCurve(180,75, 205,40, 225,90);
        oiseau1.setFill(Color.LIGHTGREY);
        oiseau1.setStroke(Color.BLACK);

        QuadCurve oiseau2 = new QuadCurve(135, 90, 150, 40, 180, 75);
        oiseau2.setStroke(Color.BLACK);
        oiseau2.setFill(Color.LIGHTGREY);

        QuadCurve oiseau3 = new QuadCurve(50,140, 75,105, 95, 160);
        oiseau3.setFill(Color.LIGHTGREY);
        oiseau3.setStroke(Color.BLACK);

        QuadCurve oiseau4 = new QuadCurve(5, 160, 20,105,50, 140);
        oiseau4.setStroke(Color.BLACK);
        oiseau4.setFill(Color.LIGHTGREY);

       Timeline timeline = new Timeline();
       timeline.setCycleCount(Timeline.INDEFINITE);

       KeyValue kv1 = new KeyValue(oiseau1.endYProperty(), 55, Interpolator.LINEAR);
       KeyFrame kf1 = new KeyFrame(Duration.seconds(1), kv1);

       KeyValue kv2 = new KeyValue(oiseau2.startYProperty(), 55, Interpolator.LINEAR);
       KeyFrame kf2 = new KeyFrame(Duration.seconds(1), kv2);

       KeyValue kv3 = new KeyValue(oiseau1.startYProperty(), 80, Interpolator.LINEAR);
       KeyFrame kf3 = new KeyFrame(Duration.seconds(1), kv3);

        KeyValue kv4 = new KeyValue(oiseau2.endYProperty(), 80, Interpolator.LINEAR);
        KeyFrame kf4 = new KeyFrame(Duration.seconds(1), kv4);

        KeyValue kv5 = new KeyValue(oiseau3.endYProperty(), 125, Interpolator.LINEAR);
        KeyFrame kf5 = new KeyFrame(Duration.seconds(1), kv5);

        KeyValue kv6 = new KeyValue(oiseau4.startYProperty(), 125, Interpolator.LINEAR);
        KeyFrame kf6 = new KeyFrame(Duration.seconds(1), kv6);

        KeyValue kv7 = new KeyValue(oiseau3.startYProperty(), 145, Interpolator.LINEAR);
        KeyFrame kf7 = new KeyFrame(Duration.seconds(1), kv7);

        KeyValue kv8 = new KeyValue(oiseau4.endYProperty(), 145, Interpolator.LINEAR);
        KeyFrame kf8 = new KeyFrame(Duration.seconds(1), kv8);

       timeline.getKeyFrames().addAll(kf1, kf2, kf3, kf4, kf5, kf6, kf7, kf8);
       timeline.setAutoReverse(true);
       timeline.play();

        //étoile
        Polygon star1 = new Polygon(585,50, 590, 60, 600, 60, 593, 70, 595, 80, 585, 73, 575, 80, 578, 70, 570, 60, 580, 60);
        star1.setFill(Color.YELLOW);
        star1.setTranslateX(10);
        star1.setTranslateY(20);

        Polygon star2 = new Polygon(485,50, 490, 60, 500, 60, 493, 70, 495, 80, 485, 73, 475, 80, 478, 70, 470, 60, 480, 60);
        star2.setFill(Color.YELLOW);
        star2.setScaleX(0.4);
        star2.setScaleY(0.4);
        star2.setTranslateX(12);
        star2.setTranslateY(20);

        Polygon star3 = new Polygon(535,70, 540, 80, 550, 80, 543, 90, 545, 100, 535, 93, 525, 100, 528, 90, 520, 80, 530, 80);
        star3.setFill(Color.YELLOW);
        star3.setScaleX(0.6);
        star3.setScaleY(0.6);
        star3.setTranslateY(-23);

        Polygon star4 = new Polygon(535,10, 540, 20, 550, 20, 543, 30, 545, 40, 535, 33, 525, 40, 528, 30, 520, 20, 530, 20);
        star4.setFill(Color.YELLOW);
        star4.setTranslateX(-60);
        star4.setScaleY(0.7);
        star4.setScaleX(0.7);

        FadeTransition fade1 = new FadeTransition(Duration.seconds(2), star1);
        fade1.setToValue(1);
        fade1.setFromValue(0);
        fade1.setCycleCount(Timeline.INDEFINITE);
        fade1.setAutoReverse(true);
        fade1.play();

        FadeTransition fade2 = new FadeTransition(Duration.seconds(1.5), star2);
        fade2.setToValue(1);
        fade2.setFromValue(0);
        fade2.setCycleCount(Timeline.INDEFINITE);
        fade2.setAutoReverse(true);
        fade2.play();

        FadeTransition fade3 = new FadeTransition(Duration.seconds(2), star3);
        fade3.setToValue(1);
        fade3.setFromValue(0);
        fade3.setCycleCount(Timeline.INDEFINITE);
        fade3.setAutoReverse(true);
        fade3.play();

        FadeTransition fade4 = new FadeTransition(Duration.seconds(2.5), star4);
        fade4.setToValue(1);
        fade4.setFromValue(0);
        fade4.setCycleCount(Timeline.INDEFINITE);
        fade4.setAutoReverse(true);
        fade4.play();

        //affichage
        Group root = new Group(rectGris, rectNoir, nuit, jour, rayonJour, soleil, lune, triangle, triangle2, rectangle, rectangle2, rectangle3,
                rectangle4, ligne, ligne2, ligne3, ligne4, rectangle5, rectangle6, porte1, porte2, oiseau1, oiseau2, oiseau3, oiseau4,
                star1, star2, star3, star4);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
