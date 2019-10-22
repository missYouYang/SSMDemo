var can1;
var can2;

var ctx1;
var ctx2;

var lastTime;
var deltaTime;

var canWidth;
var canHeight;
var bgPic = new Image();

var ane; //海葵

var fruit;//果实

var mom; //大鱼
document.body.onload = game;

var mx; //鼠标x坐标
var my; //鼠标y坐标

var baby; //小雨
function game() {
    init();
    deltaTime = 0;
    lastTime = Date.now();
    gameloop();


}

function init() {
    can1 = document.getElementById("canvas1"); //fishes,dust,UI,circle
    ctx1 = can1.getContext("2d");
    can2 = document.getElementById("canvas1"); //background ,ane,fruits
    ctx2 = can2.getContext("2d");

    //获取鼠标事件
    can1.addEventListener('mousemove',onMouseMove,false);

    canWidth = can1.width;
    canHeight = can1.height;
    bgPic.src = "../../static/image/background.jpg";
    ane = new aneObj();
    ane.init();

    fruit = new friutObj();
    fruit.init();

    mom = new momObj();
    mom.init();

    baby = new babyObj();
    baby.init();

    mx = canWidth * 0.5;
    my = canHeight * 0.5;


}

function gameloop() {
    requestAnimFrame(gameloop);
    var now = Date.now();
    deltaTime = now - lastTime; //每帧间隔的和时间，保证游戏的流畅
    lastTime = now;
    if(deltaTime > 40) deltaTime = 40;
    drawBackground();
    ane.draw();
    fruitMonitor();
    fruit.draw();

   /* ctx1.clearRect(0,0,canWidth,canHeight);*/
    mom.draw();

    momFruitsCollisiom();

    baby.draw();

}

//获取鼠标位置
function onMouseMove(e) {
    if(e.offsetX || e.layerX){
        mx = e.offsetX == undefined ? e.offsetX : e.layerX;
        my = e.offsetY == undefined ? e.offsetY : e.layerY;
    }
}

