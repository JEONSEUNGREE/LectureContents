function showPrice () {
var originPrice = document.querySelector('#productPrice').value;
var rate = document.querySelector('#rate').value;

var savedPrice = originPrice * (rate/100);
var resultPrice = originPrice - savedPrice;

document.querySelector('#showResult').innerHTML =
"상품의 원가는" + originPrice + "원이고, 할이율은" + rate + "%이다." + "" +
savedPrice + "원을 절약하여" + resultPrice + "원에 구매 할 수 있다."

}