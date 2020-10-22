import javax.swing.*;
import java.util.Random;

public class GameConfigs {
private Random random = new Random();
private JButton[] buttonArray;

public void setButtonArray(JButton[] array){
    buttonArray = array;
}

public void newGame(){
    setAllEmpty();
    for (int i = 0; i < buttonArray.length-1; i++) {
        String[] strings = new String[]{"1","2","3"};
        while (buttonArray[i].getText().isEmpty()){
            boolean randomExist = false;
            int randomNumber = random.nextInt(buttonArray.length-1);
            for (int j = 0; j < i; j++) {
                if (buttonArray[j].getText().equalsIgnoreCase(String.valueOf(randomNumber))) {
                    randomExist =false;
                    continue;
                }
            }
            randomExist = true;
            if (randomExist) {
                buttonArray[i].setText(String.valueOf(randomNumber));
                break;
            }
        }

//        int randomIndex = random.nextInt(buttonArray.length-1);
//        JButton temp = buttonArray[randomIndex];
//        buttonArray[randomIndex] =buttonArray[i];
//        buttonArray[i] = temp;
        }
    }


private boolean checkIfRandomExist(JButton[] array,int lenght,int random){

return false;
}

private void setAllEmpty(){
    for (int i = 0; i < buttonArray.length; i++) {
        buttonArray[i].setText("");
    }
}

}
