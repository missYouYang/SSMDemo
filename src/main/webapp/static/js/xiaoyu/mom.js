var momObj = function () {

    this.x;
    this.y;
    this.bigEye = new Image();  //眼睛
    this.bigBody = new Image(); //身体
    this.bigTail = new Image(); //尾巴
    this.angle; //鱼的角度
};

momObj.prototype.init = function(){

    this.x = canWidth * 0.5;
    this.y = canHeight * 0.5;
    this.bigEye.src = "../../static/image/babyEye0.png";
    this.bigBody.src = "../../static/image/bigSwim0.png";
    this.bigTail.src = "../../static/image/bigTail0.png";
    this.angle = 0;
};

momObj.prototype.draw = function () {

    //把大鱼放到一个单独的环境

    this.x = lerpDistance(mx, this.x, 0.98); //第三个参数，控制🐟跟随鼠标的速度
    this.y = lerpDistance(my, this.y, 0.98);

    //设置鱼的角度
    var deltaY = my - this.y;
    var deltaX = mx - this.x;

    var beta = Math.atan2(deltaY,deltaX) + Math.PI;

    this.angle = lerpAngle(beta,this.angle,0.6);
    ctx1.save();
    ctx1.translate(this.x,this.y);
    ctx1.rotate(this.angle); //将矩形旋转多少度：
    ctx1.drawImage(this.bigEye,-this.bigEye.width * 0.5 ,-this.bigEye.height * 0.5); //-this.bigEye.width * 0.5为了让图片在远点的中央
    ctx1.drawImage(this.bigBody,-this.bigBody.width * 0.5 ,-this.bigBody.height * 0.5);
    ctx1.drawImage(this.bigTail,-this.bigTail.width * 0.5 + 30 ,-this.bigTail.height * 0.5);
    ctx1.restore();
};