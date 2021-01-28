package model.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@ToString

//@Component //<bean id="car" class="model.domain.Car" scope="singleton"/> 동일한 설정

@Component("c") //<bean id="c" class="model.domain.Car" scope="singleton"/> 동일한 설정
@Scope("prototype")  //<bean id="car" class="model.domain.Car" scope="prototype"/> 동일한 설정
public class Car {
	private String carName;
	private int carNumber;
	
}
