package com.gn.study.controller;

import java.util.List;

import com.gn.study.model.service.Service;
import com.gn.study.model.vo.Car;

// View로부터 전달받은 데이터 가공 -> Service 전달
public class Controller {
	private Service service = new Service();

	public int insertCarOne(String modelName, int price, String date) {
		Car car = new Car(modelName, price, date);
		int result = service.insertCarOne(car);
		return result;
	}

	public List<Car> selectCarAll() {
		return service.selectCarAll();
	}

	public Car selectCarOneByModel(String model) {
		return service.selectCarOneByModel(model);
	}

	public Car selectCarOneByNumber(int number) {
		return service.selectCarOneByNumber(number);
	}

	public Car selectCarOneByPrice(int price) {
		return service.selectCarOneByPrice(price);
	}

	public Car selectCarOneByDate(String date) {
		return service.selectCarOneByDate(date);
	}

	public int deleteCarOne(int carNo) {
		return service.deleteCarOne(carNo);
	}

	public int updateModel(int carNo, Object obj) {
		return service.updateModel(carNo, obj);
	}

	public int updatePrice(int carNo, Object obj) {
		return service.updatePrice(carNo, obj);
	}

	public int updateDate(int carNo, Object obj) {
		return service.updateDate(carNo, obj);
	}

}
