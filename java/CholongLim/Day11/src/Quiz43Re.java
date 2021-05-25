import org.w3c.dom.ls.LSOutput;

//1. 랜덤 연봉 적용
//2. 직원 10명
//3. 시작 연봉 2400 ~ 3500 사이의 랜덤값
//4. 연봉 인상률 1% ~ 20% 사이의 랜덤값
//5. 10년 후 각 직원들 연봉
//6. 연 별 평균 연봉값
class AnnualIncome {

    int income;
    String name;
    float increase;
    final float PERCENT = 0.01f;

    public AnnualIncome(String name) {
//        생성자 : 초기값 설정
        this.name = name;
        income = (int) (Math.random() * 1101 + 2400);
    }

//    1명의 직원 연봉 변화
    public void clacIncIncome(){
        increase = (int) (Math.random() * 20 + 1);
        income = (int) (income + income * increase * PERCENT);
    }

    public void printIncome() {
            System.out.printf("%s의 연봉은 = %d\n", name, income);
    }

    public int getIncome() {
        return income;
    }
}
public class Quiz43Re {
    public static void main(String[] args) {
        String name[] = {"가가", "나나", "다다", "라라", "마마",
                "바바", "사사", "아아", "자자", "차차"};

        int len = name.length;
        AnnualIncome[] ai = new AnnualIncome[len];


        for (int i = 0; i < len; i++) {
            ai[i] = new AnnualIncome(name[i]);
        }

        int year = 10;
//        5. 10년 후 각 직원들 연봉
        for (int i = 0; i < year; i++) {
            float sum = 0;
            for (int j = 0; j < len; j++) {
                ai[j].clacIncIncome();
                //6. 연 별 평균 연봉값
                sum += ai[j].getIncome();
                ai[j].printIncome();
            }
            System.out.println("올해 평균 연봉 = " + sum / 10.0f );
        }


    }
}
