package ch04.내부클래스;

import org.jetbrains.annotations.NotNull;

/**
 * 자바와 코틀린의 중첩 클래스 차이점에 대해 학습
 * NotSerializableException: Button 이라는 오류가 발생한다.
 * 직렬화하려는 변수는 ButtonState 타입인데 왜 Button을 직렬화할 수 없다는 에외가 발생할까?
 * 자바에서 다른 클래스 안에 정의한 클래스는 자동으로 내부 클래스(inner class)가 된다.
 * ButtonState 클래스는 바깥쪽 Button 클래스에 대한 참조를 묵시적으로 포함한다.
 * Button을 직렬화할 수 없으므로 Button에 대한 참조가 ButtonState의 직렬화를 방해한다.
 * 이 문제를 해결하려면 ButtonState를 static 클래스로 선언해야 한다.
 * 자바에서 중첩 클래스를 static으로 선언하면 그 클래스를 둘러싼 바깥쪽 클래스에 대한 묵시적인 참조가 사라진다.
 *
 */
public class Button implements View {
	@NotNull
	@Override
	public State getCurrentState() {
		return new ButtonState();
	}

	@Override
	public void restoreState(@NotNull State state) {
		View.super.restoreState(state);
	}

	public class ButtonState implements State {
	}
}
