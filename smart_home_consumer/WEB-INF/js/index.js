$(function() {
	var phone,address;
	//定义锁屏时钟
	function clock() {
		var date = new Date();
		var month = date.getMonth(); //月
		var day = date.getDate(); //日
		var weekDay = date.getDay(); //星期
		var h = date.getHours();
		var m = date.getMinutes();
		var s = date.getSeconds();
		if(m < 9) {
			m = "0" + m;
		}
		if(s < 9) {
			s = "0" + s;
		}
		switch(weekDay) {
			case 0:
				weekDay = "日"
				break;
			case 1:
				weekDay = "一"
				break;
			case 2:
				weekDay = "二"
				break;
			case 3:
				weekDay = "三"
				break;
			case 4:
				weekDay = "四"
				break;
			case 5:
				weekDay = "五"
				break;
			case 6:
				weekDay = "六"
				break;
		}
		$(".dateHour").text(h);
		$(".dateMinute").text(m);
		$(".dateSecond").text(s);
		$(".dataMonth").text(month + 1);
		$(".dateDay").text(day);
		$(".dateWeek").text(weekDay);
	}

	//淡入
	$(document).on("click", "#lockScreen", function() {
		$(".Mask").slideDown("slow");
		$(".Mask").addClass("in");
		window.setInterval(clock, 1000);
	});

	//淡出
	$(document).on("click", ".MaskImg", function() {
		$(".Mask").slideUp();
		$(".Mask").removeClass("in");
		window.clearInterval(window.setInterval(clock, 1000));
	});

	$(document).on("keydown", function(event) {
		var keyCode = event.keyCode || event.which;
		if(keyCode == "13") {
			event.preventDefault();
			$(".Mask").slideUp();
			$(".Mask").removeClass("in");
			window.clearInterval(window.setInterval(clock, 1000));
		}
	});

	clock();

	


	//设置主页时间
	function homeClock() {
		var date = new Date();
		var year = date.getFullYear(); //年
		var month = date.getMonth(); //月
		var day = date.getDate(); //日
		var weekDay = date.getDay(); //星期
		var h = date.getHours();
		var m = date.getMinutes();
		var s = date.getSeconds();
		if(m < 9) {
			m = "0" + m;
		}
		if(s < 9) {
			s = "0" + s;
		}
		switch(weekDay) {
			case 0:
				weekDay = "日"
				break;
			case 1:
				weekDay = "一"
				break;
			case 2:
				weekDay = "二"
				break;
			case 3:
				weekDay = "三"
				break;
			case 4:
				weekDay = "四"
				break;
			case 5:
				weekDay = "五"
				break;
			case 6:
				weekDay = "六"
				break;
		}

		//设置主页时间
		$(".localTime").text(h + " : " + m);
		$(".localDate").text(year + "年" + month + "月" + day + "日" + "  星期" + weekDay);
	}
	window.setInterval(homeClock, 1000);
})

/* 摄像模块 */
//清空LocalStorage方法
//页面跳转并弹出模态框
setInterval("test()", 1000);
//console.log(jsonObj.data); // 29
var stream;

function test() {

	var video = document.querySelector('video');
	//初始化对话框
	var inst = new mdui.Dialog('#cameraDialog');
	//监听对话框关闭事件，然后进行销毁
	var dialog = document.getElementById('cameraDialog');
	dialog.addEventListener('closed.mdui.dialog', function() {
		stream.getTracks().forEach(function(track) {
			track.stop();
		});
	});

	var ch = 0;
	var getLocalData = localStorage.getItem('localData'); // 读取字符串数据
	if(getLocalData != null) {
		var jsonObj = JSON.parse(getLocalData);
		ch = jsonObj.data;
		if(ch == 1) {
			inst.open();
			//添加video
			var opt = {
				audio: true,
				video: {
					width: 500,
					height: 300
				}
			};
			navigator.mediaDevices.getUserMedia(opt)
				.then(function(mediaStream) {
					stream = mediaStream;
					console.log("赋值成功");
					video.srcObject = mediaStream;
					video.onloadedmetadata = function(e) {
						video.play();
					};
				})
				.catch(function(err) {
					console.log(err.name + ": " + err.message);
				});
			localStorage.clear();
		}
	}
}

/* 发送语音 */
/* var timeout = 0;
$("#sendVoice").mousedown(function() {
	console.log("mousedown");
	timeout = setTimeout(function() {
		timeout = 0;
		console.log("start");
	}, 1000);
});

$("#sendVoice").mouseup(function() {
	console.log(timeout);
	console.log("start");
	if (timeout != 0) {
		alert("触发点击事件");
	} else{
		alert("结束长按事件");
	}
	clearTimeout(timeout);
});

$("#sendVoice").mouseout(function() {
	console.log("mouseout");
	clearTimeout(timeout);
}); */

<!-- 拖拽 -->
$(function() {
	$(".gridster ul").gridster({
		widget_margins: [0, 0],
		widget_base_dimensions: [144, 108]
	});
});

<!--ajax调取数据-->
var acdata;
var dfdata;
var refdata;
var washdata;
var livinglampdata;
var bedlampdata;
var livinglampnum = 1;
var bedlampnum = 1;
var wamodenum = 0;
var watimenum = 0;
var refnum = 0;
var dfmode = 0;
var acmode = 0;
var acspeed = 0;
var acdirection = 0;

function refreshAirData() {
	/*读取空调数据*/
	$.ajax({
		type: "post",
		url: "http://localhost:9988/getAcByAid/2",
		dataType: "json",
		success: function(data) {
			console.log(data);
			var temp = data.temp;
			$(".air-temp").html(temp);
			$(".acimage").html("");
			$(".aclogo").html("");
			switchlogo = `<img src="images/` + data.switch_status + `.png" class="switch-status" >`
			logo = `<img src="images/air-conditioning/mode/` + data.mode +
				`.png" class="air-mode other-status" />
					<img src="images/air-conditioning/speed/` + data.speed +
				`.png" class="air-speed other-status" />
					<img src="images/air-conditioning/time/clock.png" class="air-time other-status" />
					<img src="images/air-conditioning/direction/` +
				data.direction + `.png" class="air-direction other-status" />`;
			$(".aclogo").append(switchlogo);
			$(".acimage").append(logo);
			acdata = data;
		},
		error: function(error) {
			console.log(error);
		}
	});
};

function refreshDrinkData() {
	/*读取饮水机数据*/
	$.ajax({
		type: "post",
		url: "http://localhost:9988/getDfBydid/1",
		dataType: "json",
		success: function(data) {
			console.log(data);
			var mode = data.mode;
			if(mode == 0) {
				dtemp = 100;
			} else if(mode == 1) {
				dtemp = 90;
			} else if(mode == 2) {
				dtemp = 80;
			} else if(mode == 3) {
				dtemp = 65;
			} else if(mode == 4) {
				dtemp = 45;
			}
			$(".dfimage").html("");
			$(".dflogo").html("");
			switchlogo = `<img src="images/` + data.switch_status + `.png" class="switch-status" >`
			logo = `<img src="images/drinking-fountain/` + data.mode + `.png" class="drink-icon other-status" />`
			$(".dflogo").append(switchlogo);
			$(".dfimage").append(logo);
			$(".drink-temp").html(dtemp);
			dfdata = data;
		},
		error: function(error) {
			console.log(error);
		}
	});
}

function getWM() {
	//读取洗衣机
	$.ajax({
		type: "post",
		url: "http://localhost:9988/getWMByWid/1",
		dataType: "json ",
		success: function(data) {
			console.log(data);
			var time = data.time;
			$(".was-temp").html(time);
			washdata = data;
			$(".washimage").html("");
			$(".washilogo ").html("");
			switchlogo = `<img src="images/` + data.switch_status + `.png" class="switch-status" >`
			logo = `<img src="images/washing-machine/mode/` + data.mode + `.png" class="drink-icon other-status" />`
			$(".washilogo ").append(switchlogo);
			$(".washimage ").append(logo);
		},
		error: function(error) {
			console.log(error);
		}
	});
}
//读取冰箱
function getRefrigerator() {
	$.ajax({
		type: "post",
		url: "http://localhost:9988/getRefrigeratorByRid/1",
		dataType: "json ",
		success: function(data) {
			var gear = data.gear;
			$(".reflogo ").html("");
			switchlogo = `<img src="images/` + data.switch_status + `.png" class="switch-status" >`
			$(".reflogo ").append(switchlogo);
			$(".ref-gear ").html(gear);
			refdata = data;
		},
		error: function(error) {
			console.log(error);
		}
	});
}

//读取客厅灯
function refreshLivingLamp() {
	$.ajax({
		type: "post",
		url: "http://localhost:9988/getLampBylid/2",
		dataType: "json ",
		success: function(data) {
			var gear = data.gear;
			$(".livinglamplogo").html("");
			$(".livinglampimage ").html("");
			switchlogo = `<img src="images/` + data.switch_status + `.png" class="switch-status" >`
			logo = `<img src="images/lamp/mode/` + data.mode + `.png" class="drink-icon other-status" />`
			$(".livinglamplogo").append(switchlogo);
			$(".livinglampimage ").append(logo);
			livinglampdata = data;
		},
		error: function(error) {
			console.log(error);
		}
	});
}

//读取卧室灯
function refreshBedLamp() {
	$.ajax({
		type: "post",
		url: "http://localhost:9988/getLampBylid/1",
		dataType: "json ",
		success: function(data) {
			var gear = data.gear;
			$(".bedlamplogo").html("");
			$(".bedlampimage ").html("");
			switchlogo = `<img src="images/` + data.switch_status + `.png" class="switch-status" >`
			logo = `<img src="images/lamp/mode/` + data.mode + `.png" class="drink-icon other-status" />`
			$(".bedlamplogo").append(switchlogo);
			$(".bedlampimage ").append(logo);
			bedlampdata = data;
		},
		error: function(error) {
			console.log(error);
		}
	});
}

function showhidden() {
	if(localStorage.getItem("key1") == 1) {
		$(".booklamp").css("display", "");
	}
	if(localStorage.getItem("key2") == 2) {
		$(".tv").css("display", "");
	}
	if(localStorage.getItem("key3") == 3) {
		$(".radio").css("display", "");
	}
}
setInterval("showhidden()", 2000);
$(function() {
	    getUser();
		var dtemp = 0;
		refreshAirData();
		refreshDrinkData();
		//读取冰箱
		getWM();
		//读取洗衣机
		getRefrigerator();
		refreshLivingLamp();
		refreshBedLamp();
		$(".setbackground").click(function() {
			$(this).css("background-color", "#40C4FF");
			$(this).siblings().css("background-color", "");
		})
		$(".wash").css("display", "");

	})
	/*读取空调修改数据*/
function acmodebtn(modeobj) {
	acmode = modeobj
}

function acspeedbtn(speedobj) {
	acspeed = speedobj;
}

function acdirectionbtn(directionobj) {
	acdirection = directionobj;
}
/*读取饮水机数据*/
function dfmodebtn(modeobj) {
	dfmode = modeobj;
}
/*修改空调数据*/
function updateac() {
	var actemp = 0;
	var aircheck = 0;
	$(".mdui-slider-thumb").each(function(i, n) {
		if(i == 1) {
			actemp = $(n).text();
		}
	})
	var acselecttime = $(".mdui-select-selected").html();
	if(acselecttime == "") {
		acselecttime = "0";
	}
	if(actemp == "") {
		actemp = acdata.temp;
	}
	actime = parseInt(acselecttime.substring(0, 1));
	var checkbox = $("#aircheck").is(':checked');
	if(checkbox) {
		aircheck = 1;
	} else {
		aircheck = 0;
	}
	$.ajax({
		type: "post",
		url: "http://localhost:9988/updateAid",
		data: {
			aid: acdata.aid,
			aname: acdata.aname,
			temp: actemp,
			mode: acmode,
			speed: acspeed,
			time: actime,
			direction: acdirection,
			switch_status: aircheck,
			connect_status: acdata.connect_status
		},
		dataType: "json",
		success: function(data) {
			console.log(data);
			refreshAirData();
			var acspeech = document.createElement('audio');
			acspeech.setAttribute('src', 'speech/空调.mp3');
			if(aircheck == 1) {
				acspeech.play();
			}
			localStorage.setItem("type",1);
		},
		error: function(error) {
			console.log(error);
		}
	});
}
//修改饮水机数据
function updatedf() {
	var drinkcheck = 0;
	var checkbox = $("#drinkcheck").is(':checked');
	if(checkbox) {
		drinkcheck = 1;
	} else {
		drinkcheck = 0;
	}
	$.ajax({
		type: "post",
		url: "http://localhost:9988/updateDf",
		data: {
			did: dfdata.did,
			dname: dfdata.dname,
			mode: dfmode,
			switch_status: drinkcheck,
			connect_status: dfdata.connect_status
		},
		dataType: "json",
		success: function(data) {
			console.log(data);
			refreshDrinkData();
			var dfspeech = document.createElement('audio');
			dfspeech.setAttribute('src', 'speech/饮水机.mp3');
			if(drinkcheck == 1) {
				dfspeech.play();
			}
			localStorage.setItem("type",3);
		},
		error: function(error) {
			console.log(error);
		}
	});
}

//获取冰箱档位
function gearbtnnum(obj) {
	refnum = obj;
};
//执行冰箱修改档位
function updateref() {
	var refcheck = 0;
	var checkbox = $("#refcheck").is(':checked');
	if(checkbox) {
		refcheck = 1;
	} else {
		refcheck = 0;
	}
	$.ajax({
		type: "post",
		url: "http://localhost:9988/updateRefrigerator",
		data: {
			rid: refdata.rid,
			rname: refdata.rname,
			gear: refnum,
			switch_status: refcheck,
			connect_status: refdata.connect_status,
		},
		dataType: "json",
		success: function(data) {
			getRefrigerator();
			var refspeech = document.createElement('audio');
			refspeech.setAttribute('src', 'speech/冰箱.mp3');
			if(refcheck == 1) {
				refspeech.play();
			}
			localStorage.setItem("type",2);
		},
		error: function(error) {
			console.log(error);
		}
	});
}
//获取洗衣机模式
function mduibutnum(obj) {
	wamodenum = obj;
	console.log(washdata);
};
//获取洗衣机时间
function time(obj) {
	watimenum = obj;
}
//修改洗衣机模式以及时间
function updaWash() {
	var washcheck = 0;
	var checkbox = $("#washcheck").is(':checked');
	if(checkbox) {
		washcheck = 1;
	} else {
		washcheck = 0;
	}
	$.ajax({
		type: "post",
		url: "http://localhost:9988/updateWM",
		data: {
			wid: washdata.wid,
			wname: washdata.wname,
			mode: wamodenum,
			time: watimenum,
			switch_status: washcheck,
			connect_status: washdata.connect_status,
		},
		dataType: "json ",
		success: function(data) {
			getWM();
			var washspeech = document.createElement('audio');
			washspeech.setAttribute('src', 'speech/洗衣机.mp3');
			if(washcheck == 1) {
				washspeech.play();
			}
			localStorage.setItem("type",6);
		},
		error: function(error) {
			console.log(error);
		}
	});
}
//读取灯的档位
function livinglampbtnnum(obj) {
	livinglampnum = obj;
}

function bedlampbtnnum(obj) {
	bedlampnum = obj;

}

//执行客厅灯修改档位
function updatelivinglamp() {
	var livinglampcheck = 0;
	var checkbox = $("#livinglampcheck").is(':checked');
	if(checkbox) {
		livinglampcheck = 1;
	} else {
		livinglampcheck = 0;
	}
	$.ajax({
		type: "post",
		url: "http://localhost:9988/updateLamp",
		data: {
			lid: livinglampdata.lid,
			lname: livinglampdata.lname,
			mode: livinglampnum,
			switch_status: livinglampcheck,
			connect_status: livinglampdata.connect_status,
		},
		dataType: "json",
		success: function(data) {
			refreshLivingLamp();
			var lampspeech = document.createElement('audio');
			lampspeech.setAttribute('src', 'speech/灯.mp3');
			lampspeech.play();
			localStorage.setItem("type",4);
		},
		error: function(error) {
			console.log(error);
		}
	});
}

//执行卧室灯修改档位
function updatebedlamp() {
	var bedlampcheck = 0;
	var checkbox = $("#bedlampcheck").is(':checked');
	if(checkbox) {
		bedlampcheck = 1;
	} else {
		bedlampcheck = 0;
	}
	$.ajax({
		type: "post",
		url: "http://localhost:9988/updateLamp",
		data: {
			lid: bedlampdata.lid,
			lname: bedlampdata.lname,
			mode: bedlampnum,
			switch_status: bedlampcheck,
			connect_status: bedlampdata.connect_status,
		},
		dataType: "json",
		success: function(data) {
			refreshBedLamp();
			var lampspeech = document.createElement('audio');
			lampspeech.setAttribute('src', 'speech/灯.mp3');
			lampspeech.play();
			localStorage.setItem("type",5);
		},
		error: function(error) {
			console.log(error);
		}
	});
}

<!-- 切换壁纸 -->


function switchColor() {
	/* 纯色变换 */
	var colorAngle = Math.floor(Math.random() * 360);
	console.log(colorAngle);
	var color = 'hsla(' + colorAngle + ',100%,50%,1)';
	console.log(color);
	document.body.style.background = color;
}

$("#brightness").on('input propertychange', function() {
	var bright = $("#brightness").val();
	var brightness = "brightness(" + bright + "%)";
	$(".main").css("filter", brightness);
})

$(document).on("click", "#lockScreen", function() {
	$(".mask").slideDown();
});

$(document).on("click", ".maskImg", function() {
	$(".mask").slideUp();
});

function openair() {
	/*开空调*/
	$.ajax({
		type: "post",
		url: "http://localhost:9988/updateAid",
		data: {
			aid: acdata.aid,
			aname: acdata.aname,
			temp: 26,
			mode: 0,
			speed: 0,
			time: 0,
			direction: 0,
			switch_status: 1,
			connect_status: acdata.connect_status
		},
		dataType: "json",
		success: function(data) {
			refreshAirData();
		},
		error: function(error) {
			console.log(error);
		}
	});
}

function closeair() {
	/*关空调*/
	$.ajax({
		type: "post",
		url: "http://localhost:9988/updateAid",
		data: {
			aid: acdata.aid,
			aname: acdata.aname,
			temp: 26,
			mode: 0,
			speed: 0,
			time: 0,
			direction: 0,
			switch_status: 0,
			connect_status: acdata.connect_status
		},
		dataType: "json",
		success: function(data) {
			refreshAirData();
		},
		error: function(error) {
			console.log(error);
		}
	});
}

function opendrink() {
	/*开饮水机*/
	$.ajax({
		type: "post",
		url: "http://localhost:9988/updateDf",
		data: {
			did: dfdata.did,
			dname: dfdata.dname,
			mode: dfdata.mode,
			switch_status: 1,
			connect_status: dfdata.connect_status
		},
		dataType: "json",
		success: function(data) {
			refreshDrinkData();
		},
		error: function(error) {
			console.log(error);
		}
	});
}

function closedrink() {
	/*关饮水机*/
	$.ajax({
		type: "post",
		url: "http://localhost:9988/updateDf",
		data: {
			did: dfdata.did,
			dname: dfdata.dname,
			mode: dfdata.mode,
			switch_status: 0,
			connect_status: dfdata.connect_status
		},
		dataType: "json",
		success: function(data) {
			refreshDrinkData();
		},
		error: function(error) {
			console.log(error);
		}
	});
}

function openlivinglamp() {
	/*开客厅灯*/
	$.ajax({
		type: "post",
		url: "http://localhost:9988/updateLamp",
		data: {
			lid: livinglampdata.lid,
			lname: livinglampdata.lname,
			mode: livinglampdata.mode,
			switch_status: 1,
			connect_status: livinglampdata.connect_status,
		},
		dataType: "json",
		success: function(data) {
			refreshLivingLamp();
		},
		error: function(error) {
			console.log(error);
		}
	});
}
/*关客厅灯*/
function closelivinglamp() {

	$.ajax({
		type: "post",
		url: "http://localhost:9988/updateLamp",
		data: {
			lid: livinglampdata.lid,
			lname: livinglampdata.lname,
			mode: livinglampdata.mode,
			switch_status: 0,
			connect_status: livinglampdata.connect_status,
		},
		dataType: "json",
		success: function(data) {
			refreshLivingLamp();
		},
		error: function(error) {
			console.log(error);
		}
	});
}

//关卧室灯
function closebedlamp() {
	$.ajax({
		type: "post",
		url: "http://localhost:9988/updateLamp",
		data: {
			lid: bedlampdata.lid,
			lname: bedlampdata.lname,
			mode: bedlampdata.mode,
			switch_status: 0,
			connect_status: bedlampdata.connect_status,
		},
		dataType: "json",
		success: function(data) {
			refreshBedLamp();
		},
		error: function(error) {
			console.log(error);
		}
	});
}

//开卧室灯
function openbedlamp() {
	$.ajax({
		type: "post",
		url: "http://localhost:9988/updateLamp",
		data: {
			lid: bedlampdata.lid,
			lname: bedlampdata.lname,
			mode: bedlampdata.mode,
			switch_status: 1,
			connect_status: bedlampdata.connect_status,
		},
		dataType: "json",
		success: function(data) {
			refreshBedLamp();
		},
		error: function(data) {
			console.log("数据修改失败 ");
		}
	});
}


//开影院灯
function opentvlamp() {
	switchlogo = `<img src="images/1.png" class="switch-status" >`;
	$(".tvlamplogo").html("");
	$(".tvlamplogo").append(switchlogo);
}
//开音箱
function openspeaker() {
	switchlogo = `<img src="images/1.png" class="switch-status" >`;
	$(".speaklogo").html("");
	$(".speaklogo").append(switchlogo);
}
//开电视
function opentv() {
	switchlogo = `<img src="images/1.png" class="switch-status" >`;
	$(".tvlogo").html("");
	$(".tvlogo").append(switchlogo);
}

//关影院灯
function closetvlamp() {
	switchlogo = `<img src="images/0.png" class="switch-status" >`;
	$(".tvlamplogo").html("");
	$(".tvlamplogo").append(switchlogo);
}

//关音箱
function closespeaker() {
	switchlogo = `<img src="images/0.png" class="switch-status" >`;
	$(".speaklogo").html("");
	$(".speaklogo").append(switchlogo);
}

//关电视
function closetv() {
	switchlogo = `<img src="images/0.png" class="switch-status" >`;
	$(".tvlogo").html("");
	$(".tvlogo").append(switchlogo);
}

/*回家按钮*/
$(".gohome").on("click", function() {
		openair();
		var acspeech = document.createElement('audio');
		acspeech.setAttribute('src', 'speech/回家.mp3');
		acspeech.play();
		setTimeout("opendrink()", 1000);
		setTimeout("openbedlamp()", 2000);
		setTimeout("openlivinglamp()", 1500);
		setTimeout(function(){
			localStorage.setItem("type",7);
		}, 2000);
	})
//出门按钮
$(".goout").on("click", function() {
		closeair();
		
		var acspeech = document.createElement('audio');
		acspeech.setAttribute('src', 'speech/离家.mp3');
		acspeech.play();
		setTimeout("closedrink()", 500);
		setTimeout("closelivinglamp()", 1000);
		setTimeout("closebedlamp()", 1500);
		setTimeout("closetv()", 2000);
		setTimeout("closespeaker()", 2000);
		setTimeout("closetvlamp()", 2000);
		
	})
	//影院模式
$(".cinema").on("click", function() {
		closelivinglamp();
		localStorage.setItem("type",9);
		var acspeech = document.createElement('audio');
		acspeech.setAttribute('src', 'speech/影院模式.mp3');
		acspeech.play();
		setTimeout("opentvlamp()", 1000);
		setTimeout("opentv()", 1500);
		setTimeout("openspeaker()", 2000);
	})
	//睡眠模式
$(".sleep").on("click", function() {
	closelivinglamp();
	var acspeech = document.createElement('audio');
	acspeech.setAttribute('src', 'speech/睡眠.mp3');
	acspeech.play();
	setTimeout("closelivinglamp()", 500);
	setTimeout("closebedlamp()", 1000);
	setTimeout("closetv()", 1500);
	setTimeout("closedrink()", 2000);
	setTimeout("closespeaker()", 2000);
	setTimeout("closetvlamp()", 2000);
	setTimeout(function(){
		localStorage.setItem("type",10);
	}, 2000);
})

//获取个人信息
function getUser() {
	$.ajax({
		type: "post",
		url: "http://localhost:9988/getUserByUid/1",
		dataType: "json",
		success: function(data) {
			userdata = data;
			console.log(data);
			phone=data.phone;
			address=data.address;
			$("#userTopName").val(data.uname);
			$("#userTopPhone").val(data.phone);
			$("#userTopSafePhone").val(data.emergency_phone);
			$("#userTopAddress").val(data.address);
			$("#uname").html(data.uname);
		},
		error: function(error) {
			console.log(error);
		}
	});
}
//按钮获取个人信息
$(document).on("click", "#userSearch", function(event) {
	getUser();
});

//更改信息
$(document).on("click", "#modifyUserInfo", function(event) {
	var uid = userdata.uid;
	var userName = $("#userTopName").val();
	var userPhone = $("#userTopPhone").val();
	var userSafePhone = $("#userTopSafePhone").val();
	var userAddress = $("#userTopAddress").val();
	$.ajax({
		type: "post",
		url: "http://localhost:9988/updatUser",
		data: {
			uid: uid,
			uname: userName,
			phone: userPhone,
			emergency_phone: userSafePhone,
			address: userAddress,
		},
		dataType: "json",
		success: function(data) {
			getUser();
			if(data == 1) {
				console.log("修改成功！");
			}

		},
		error: function(error) {
			console.log(error);
		}
	});
});

WIDGET = {
	ID: 'U5VIj7QfPh'
};

//全局变量
var bgVar="";

//切换背景模式
$(document).on("click", ".bgBtn", function(event){
	bgVar=$(this).val();
})

var i = 1;



function switchBgByDefault(){
	if(i == 7) {
		i = 1;
	}
	document.body.style.backgroundImage = "url('images/bg/bg" + i + ".jpg')";
	i++;
}

function switchBgByBingYing(){
	$.ajax({
		url: "https://api.ooopn.com/image/bing/api.php",
		data: {
			v: 2,
			type: "json"
		},
		success: function(data) {
			if (data.code == 200) {
				document.body.style.backgroundImage = "url(" + data.imgurl + ")";
			}
		},
		error: function(xhr, type, errorThrown) {

		}
	});
}

function switchBg() {
	/* 变换图片 */
	if(!bgVar ||bgVar=="default"){
		switchBgByDefault();
	}else if(bgVar=="biying"){
		switchBgByBingYing();
	}
}


//短信定位
$(document).on("click", "#smGps", function(event){
	console.log(phone+"\t"+address);
	$.ajax({
		type: "post",
		url: "http://localhost:9988/sendCode",
		data: {
			phone:phone,
			address:address
		},
		dataType: "json",
		success: function(data) {
			console.log(data);
			if(data.result==0){
				console.log("send message success!");
			}
		},
		error: function(error) {
			console.log(error);
		}
	});
	
})

