package Finalproject.CoronaDetector;

public class DB {



    static private String[] Questions = new String [7];



    private static void questionsFilling() {

        Questions[0]="Are you having a Fever?";
        Questions[1]="Are you suffering from dry cough?";
        Questions[2] = "Do you have any irregular difficulty in\nbreathing or shortness of breath?\n ";
        Questions[3] = "Are you suffering from chest \npain or chest pressure?";
        Questions[4] = "Do you suffer some Headache?";
        Questions[5] = "Are you suffering from Diarrhoea?";
        Questions[6] = "Do you suffer from any loss of\ntaste or smell?";

    }


    public static void on()
    { questionsFilling();}


    public static String getQuestion(int index)
    {

        return Questions[index];


    }




}
