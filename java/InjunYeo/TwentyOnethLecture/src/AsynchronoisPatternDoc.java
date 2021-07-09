public class AsynchronoisPatternDoc {
    /*
    여기서 가져가야할 주요개념

    1.Thread를 활용하는 이유는 성능을 빠르게 만들기 위함이다.
    2.비동기 패턴(Asynchronous Pattern)이란 전부 Thread를 기반으로 한다.
    3.자바 스크립트 또한 Multi Thread모델을 지원한다(자체적으로)
        (이건 최신 자바스크립트 ECMA 6부터 서포트인것같음) - Promise를 활용하여 증명
    4.Thread를 사용할 때는 Critical Section에 대한 방어가 무엇보다도 중요하다(데이터 무결성)
    5.또한 스레드는 비동기 처리를 하기 때문에 데이터의 완전한 전송을 보장하지 못할 수도 있다.
      (이 부분은 자바스크립트 Promise를 통해 살펴볼 예정)
    데이터 처리시 상호작용이 필요하면 동기처리, 필요하지않으면 비동기 처리로 생각하자

    ex)전화통화 : 동기처리
    왜? 친구한테 전화를 걸었음. 친구가 통화허용을 안하면 통화가안됨

    ex) 카카오톡 메시지 :비동기처리
    왜? 상대방이 확인하던 안하던 난 보낸다.

     */
}
