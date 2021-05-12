/*
[
(Question)
1000개의 데이터가 있다.
여기서 C에 해당하는 데이터는 30개 있다.
F에 해당하는 데이터는 500개 있다.
B에 해당하는 데이터는 240개 있다.
A에 해당하는 데이터는 700개 있다.
D에 해당하는 데이터는 350개 있다.
C 혹은 F 둘 중 하나의 케이스를 판정하고자 한다.
어떻게 하면 가장 효율적으로 이 케이스들을 찾아낼 수 있을까 고민해보자!]
====================================================================================
[
(Answer)
문제를 보면 데이터가 1000개가 있다는데, A,B,C,D,F에 해당하는 데이터를 모두 더하면 1820개가 된다.
그렇기 떄문에 1000개의 데이터가 있다는 문장은 필요가 없다고 생각한다.

문제에서 C 혹은 F 둘 중 하나를 판정하려고 한다고 하니,
C만 판정을 한다고 하면,

if(case C || Case B)

이렇게하면 된다.
C의 데이터가 30개로 압도적으로 작기때문에 관계연산자OR의 특성을 이용하여
앞의 조건인 C(30개)를 판정하여 C가 참이면 전체가 참/ C가 거짓이면 C다음 작은 데이터인 B(240개)를 판정하여 참인지 거짓인지
알게된다.]

*/
