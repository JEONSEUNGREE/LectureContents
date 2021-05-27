/*
아주 특수한 카지노에 왔다.
현재 내 수중엔 1000만원이 있다.
카지노에서 판돈을 걸 수 있고 베팅 비율은 Scanner를 통해 입력 받을 수 있다.
상대방이 파산하면 이기는 게임이다.
주사위 2개를 사용하는 게임이다.
숫자가 높은 사람이 이긴다(컴퓨터 vs 사람)
첫 번째 주사위가 짝수가 나온 경우에만 두 번째 주사위를 굴릴 수 있다.
두 번째 주사위는 특수 능력을 가지고 있는 주사위다.
숫자 1이 나오면 내 주사위 값을 + 3 할 수 있다.
숫자가 3이 나오면 상대방 주사위 값을 -2 할 수 있다.
숫자 4가 나오면 내 주사위 값이 0이 된다.
숫자 6이 나오면 각자 만든 주사위 값을 2배로 뻥튀기 한다.
(2배 뻥튀기는 첫번째 주사위 + 두번째 주사위를 모두 진행한 후 적용한다)
누가 파산하고 누가 승리를 거머쥐는지 프로그래밍해보자!
컴퓨터 돈, 내 돈, 판돈, 뽕빨 났는지 여부, 키보드 입력, 주사위 2개 사용
첫번째 주사위가 짝수가 아니면 두번째 주사위 사용 불가
두번째 주사위는 특수 스킬이 존재함
승패 판정은 두 개의 주사위 값의 합산으로 판정
 */

import java.util.Scanner;

class DiceDeathGame {
    final int MAX_PLAYER = 2;   // 총 플레이어 수 : 컴퓨터 , 사용자
    final int DICE_IDX = MAX_PLAYER + 1;
    final int START_MONEY = 1000;

    final int FIRST_IDX = 0;
    final int SECOND_IDX = 1;
    final int TOTAL_IDX = 2;  //최종 주사위 값

    final int DICE_RANGE = 6;
    final int DICE_START_OFFSET = 1;

    int comMoney;  //컴퓨터의 잔액
    int usrMoney;  //사용자의 잔액
    int betMoney;  //베팅금액

    int roundNum;  //몇번째 경기인지, 라운드

    Boolean isAlive;
    Scanner scan;

    int[] comDice;
    int[] usrDice;

    public DiceDeathGame () {
        roundNum = 0;

        comDice = new int[DICE_IDX];
        //comeDice  = new int[3]
        usrDice = new int[DICE_IDX];
        //usrDice  = new int[3]


        isAlive = true;
        scan = new Scanner(System.in);

        // ---Money = 1000;
        comMoney = START_MONEY;
        usrMoney = START_MONEY;
    }

//    베팅 금액을 정함
    private void bettingMoney () {
        System.out.printf("현재 %d 라운드입니다.\n", ++roundNum);
        System.out.printf("이게임을 시작한 당신 오늘 둘중 하나는 인생 로그아웃합니다.\n" +
                "돈이 부족하면 손모가지나 장기로 대체 가능합니다.\n" +
                "판돈을 입력하시오: ");
        betMoney = scan.nextInt();
    }

// 모든 게임의 진행
    public void gameStart () {
        do {
            bettingMoney();   // 경기의 시작을 알리며 베팅 한다.
            runDice();        // 사용자와 컴퓨터의 첫번째, 두번째 주사위를 각각 던진다.
            checkMagicDiceSkill();  //두번째 주사위의 이벤트를 체크한다.
            whoGetBetMoney();  // 승자와 패자를 구분한다.
            canWePlay();   // 금전을 모두 잃은 사람이 있다면 경기를 진행할 수 없게 한다.
            checkEachMoney();  // 금전을 모두 잃은 사람이 없다면 현재 얼마를 가지고 있는지 알려준다.
        } while (isAlive);
    }

//    수중 금전을 확인
    private void checkEachMoney () {
        System.out.printf("사용자 수중 금전: %d, 컴퓨터 수중 금전: %d\n", usrMoney, comMoney);
    }

//    파산확인 (파산 시, 게임 진행 불가능)
    private void canWePlay () {
        if (usrMoney <= 0 || comMoney <= 0) {
            isAlive = false;
        }
    }

//    승부결과에 따른 자산 변화
    private void whoGetBetMoney () {
        int usrTotDice = usrDice[TOTAL_IDX];
        int comTotDice = comDice[TOTAL_IDX];

        if (usrTotDice > comTotDice) {
            System.out.printf("이번판은 사용자가 이겼습니다! %d(사용자) vs %d(컴퓨터)\n",
                    usrTotDice, comTotDice);
            usrMoney += betMoney;
            comMoney -= betMoney;
        } else if (usrTotDice < comTotDice) {
            System.out.printf("이번판은 컴퓨터가 이겼습니다! %d(사용자) vs %d(컴퓨터)\n",
                    usrTotDice, comTotDice);
            usrMoney -= betMoney;
            comMoney += betMoney;
        } else {
            System.out.printf("승부가 나지 않았습니다! %d(사용자) vs %d(컴퓨터)\n",
                    usrTotDice, comTotDice);
        }
    }

//    두번째 주사위 값에 따른 특수효과
    private void checkSkill (int[] curDice, int[] targetDice) {
        switch (curDice[SECOND_IDX]) {
            case 1:
                curDice[TOTAL_IDX] = curDice[FIRST_IDX] + 3;
                break;
            case 3:
                targetDice[TOTAL_IDX] = targetDice[FIRST_IDX] - 2;
                break;
            case 4:
                curDice[TOTAL_IDX] = 0;
                break;
            case 6:
                curDice[TOTAL_IDX] = (curDice[FIRST_IDX] + curDice[SECOND_IDX]) * 2;
                targetDice[TOTAL_IDX] = (targetDice[FIRST_IDX] + targetDice[SECOND_IDX]) * 2;
                break;
            default:
                curDice[TOTAL_IDX] = curDice[FIRST_IDX] + curDice[SECOND_IDX];
                break;
        }
    }

//    checkSkill (int[] curDice, int[] targetDice)를 사용하기 위한 관점
    private void checkMagicDiceSkill () {
        // 사용자 관점에서의 2번째 주사위 스킬 발동
        checkSkill(usrDice, comDice);
        // 컴퓨터 관점에서의 2번째 주사위 스킬 발동
        checkSkill(comDice, usrDice);
    }

//    두번째 주사위
    private void runSecondDice (int[] dice) {
        if (dice[FIRST_IDX] % 2 == 0) {
            dice[SECOND_IDX] = getRandomValue(DICE_RANGE, DICE_START_OFFSET);
        }
    }

//    첫번째 주사위
    private void runFirstDice (int[] dice) {
        // 첫번째 주사위의 범위값(1 ~ 6)
        dice[FIRST_IDX] = getRandomValue(DICE_RANGE, DICE_START_OFFSET);
    }

//    첫번째, 두번째 주사위를 던짐
    private void runDice () {
        //usrDice[0] = getRandomValue(6, 1);
        //comDice[0] = getRandomValue(6, 1);
        runFirstDice(usrDice);
        runFirstDice(comDice);

        /*
        if (usrDice[0] % 2 == 0) {
            usrDice[1] = getRandomValue(6, 1);
        }
        if (comDice[0] % 2 == 0) {
            comDice[1] = getRandomValue(6, 1);
        }
         */
        runSecondDice(usrDice);
        runSecondDice(comDice);
    }

    public int getRandomValue (int range, int startOffset) {
        return (int)(Math.random() * range + startOffset);
    }
}

public class Quiz45Explain {
    public static void main(String[] args) {
        DiceDeathGame ddg = new DiceDeathGame();

        ddg.gameStart();
    }
}
