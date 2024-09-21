import java.util.HashMap;
import java.util.Random;

public class MontyHall {
    public static void main(String[] args) {
        Random rnd = new Random();
        int winDoor;
        int playerChoice;
        HashMap<Integer, Boolean> data = new HashMap<>();

        for (int i = 0; i < 1000; i++) {
            winDoor = rnd.nextInt(3);
            playerChoice = rnd.nextInt(3);
            data.put(i, removeOneDoor(winDoor, playerChoice));
        }
        calculatePercentage(data);
    }

    public static boolean removeOneDoor(int winDoor, int playerChoice) {
        if (winDoor == playerChoice) {
            return false;
        } else {
            return true;
        }
    }

    public static void calculatePercentage(HashMap<Integer, Boolean> data) {
        int winValue = 0;
        double result;
        int size = data.size();
        for (Boolean value : data.values()) {
            if (value.equals(true)) {
                winValue++;
            }
        }
        result = (double) winValue / size * 100;
        System.out.println("correct answers: " + winValue + "\npercent: " + Math.round(result) + "%");
    }
}

//Реализовать код для демонстрации парадокса Монти Холла
//(запустить игру в цикле на 1000 и вывести итоговый счет)
//Необходимо:
//Создать свой Java Maven или Gradle проект;
//Подключить зависимость lombok.
//Можно подумать о подключении какой-нибудь математической библиотеки для работы со статистикой
//Самостоятельно реализовать прикладную задачу;
//Сохранить результат в HashMap<шаг теста, результат>
//Вывести на экран статистику по победам и поражениям