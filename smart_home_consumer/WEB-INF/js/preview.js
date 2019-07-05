window.localStorage.setItem("air", 25);
setInterval("refresh()", 1000);

function refresh() {
	var type = window.localStorage.getItem("type");
	switch (parseInt(type)) {
		//开启空调
		case 1:
			//window.clearInterval(window.setInterval("refresh()", 1000));
			dealAir();
			break;
			//开启冰箱
		case 2:
			//dealRef();
			break;
			//开启饮水机
		case 3:
			dealDrink();
			break;
			//开启客厅灯
		case 4:
			dealLiving();
			break;

			//开启厨房灯
		case 5:
			dealKitchen();
			break;
		case 7:
			back();
			break;
		case 8:
			leave();
			break;
		case 9:
			cinema();
			break;
		case 10:
			sleep();
			break;
		default:
			break;
	}
	window.localStorage.setItem("type", 0);
}

function dealAir() {
	var dialog = new mdui.Dialog("#airDialog");
	dialog.open();
	$.ajax({
		type: "post",
		url: "http://localhost:9988/getAcByAid/2",
		dataType: "json",
		success: function(data) {
			if (data.switch_status == 1) {
				var temp = window.localStorage.getItem("air");
				window.localStorage.setItem("temp", temp);
				$(".temp").text(data.temp);
			} else {
				$(".temp").text("");
			}
		},
		error: function(data) {
			console.log("数据读取失败");
		}
	});
	setTimeout(function() {
		dialog.close();
	}, 2000);
}

function dealRef() {
	var dialog = new mdui.Dialog("#refDialog");
	dialog.open();
	$.ajax({
		type: "post",
		url: "http://localhost:9988/getRefrigeratorByRid/1",
		dataType: "json ",
		success: function(data) {
			console.log(data);
			if (data.switch_status == 1) {
				var gear = window.localStorage.getItem("gear");
				window.localStorage.setItem("gear", gear);
				$(".gear").text(data.gear);
			} else {
				$(".gear").text("");
			}
		},
		error: function(error) {
			console.log(error);
		},
	});
	setTimeout(function() {
		//dialog.close();
	}, 2000);
}

function dealDrink() {
	var dialog = new mdui.Dialog("#drinkDialog");
	dialog.open();
	$.ajax({
		type: "post",
		url: "http://localhost:9988/getDfBydid/1",
		dataType: "json",
		success: function(data) {
			var mode = data.mode;
			if (mode == 0) {
				dtemp = 100;
			} else if (mode == 1) {
				dtemp = 90;
			} else if (mode == 2) {
				dtemp = 80;
			} else if (mode == 3) {
				dtemp = 65;
			} else if (mode == 4) {
				dtemp = 45;
			}
			if (data.switch_status == 1) {
				window.localStorage.setItem("dtemp", dtemp);
				$(".dtemp").text(dtemp);
			} else {
				$(".dtemp").text("");
			}
		},
		error: function(data) {
			console.log("数据读取失败");
		}
	});
	setTimeout(function() {
		dialog.close();
	}, 2000);
}

function dealLiving() {
	$.ajax({
		type: "post",
		url: "http://localhost:9988/getLampBylid/2",
		dataType: "json ",
		success: function(data) {
			if (data.switch_status == 1) {
				$(".left").css("filter", "brightness(100%)");
				$(".left").css("background", "rgba(255, 255, 255, 0)");
				$(".left").css("border-radius", "5px");
				$(".left").css("box-shadow", "inset 0 0 200px #FFF68F");
			} else {
				$(".left").css("filter", "brightness(50%)");
				$(".left").css("background", "rgba(255, 255, 255, 0.1)");
				$(".left").css("box-shadow", "0 0 0 yellow");
			}
		},
		error: function(data) {
			console.log("数据读取失败 ");
		},
	})
}

function dealKitchen() {
	$.ajax({
		type: "post",
		url: "http://localhost:9988/getLampBylid/1",
		dataType: "json ",
		success: function(data) {
			if (data.switch_status == 1) {
				$(".right").css("filter", "brightness(100%)");
				$(".right").css("background", "rgba(255, 255, 255, 0)");
				$(".right").css("border-radius", "5px");
				$(".right").css("box-shadow", "inset 0 0 200px #FFF68F");
			} else {
				$(".right").css("filter", "brightness(50%)");
				$(".right").css("background", "rgba(255, 255, 255, 0.1)");
				$(".right").css("box-shadow", "0 0 0 yellow");
			}
		},
		error: function(data) {
			console.log("数据读取失败 ");
		},
	})
}


function back() {
	dealAir();
	dealLiving();
	dealKitchen();
}

function leave() {
	dealAir();
	dealLiving();
	dealKitchen();
	console.log("4秒hou");
	setTimeout("dealDrink()", 1000);

	$(".tv").css("box-shadow", "0  0  0  0  yellow");
}

function cinema() {
	$(".left").css("filter", "brightness(0%)");
	$(".left").css("background", "rgba(255, 255, 255, 0.7)");
	$(".left").css("box-shadow", "0 0 0 yellow");

	$(".right").css("filter", "brightness(0%)");
	$(".right").css("background", "rgba(255, 255, 255, 0.7)");
	$(".right").css("box-shadow", "0 0 0 yellow");

	$(".tv").css("box-shadow", "0px  50px  100px  0  yellow");
}

function sleep() {

	dealDrink();

	$(".left").css("filter", "brightness(0%)");
	$(".left").css("background", "rgba(255, 255, 255, 0.7)");
	$(".left").css("box-shadow", "0 0 0 yellow");

	$(".right").css("filter", "brightness(0%)");
	$(".right").css("background", "rgba(255, 255, 255, 0.7)");
	$(".right").css("box-shadow", "0 0 0 yellow");

	$(".tv").css("box-shadow", "0  0  0  0  yellow");
}
