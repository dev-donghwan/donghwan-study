package com.donghwan.study.design.observer;

public class AppMain {

    /*
     * 예제의 설정
     * 가장 보편적인 설정이라고 볼 수 있는 Youtuber와 Subscriber들의 관계로 예제를 설정하였습니다.
     * Youtuber가 새로운 영상을 올리거나, 공지를 등록하는 것을 모두 notify 함수로 개념을 통일하여서 작성하였습니다.
     */
    public static void main(String[] args) {
        Youtuber youtuber = new Youtuber("Donghwan");

        Observer subscriber1 = new Subscriber("철수");
        Observer subscriber2 = new Subscriber("영희");

        youtuber.registerObserver(subscriber1);
        youtuber.registerObserver(subscriber2);
        youtuber.notify("Youtube에 새로운 영상이 올라왔습니디.");
        youtuber.unRegisterObserver(subscriber2);
        youtuber.notify("Youtube에 새로운 공지가 올라왔습니다.");
    }
}
