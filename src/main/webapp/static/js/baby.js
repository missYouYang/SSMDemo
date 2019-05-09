var babyObj = function () {

    this.x;
    this.y;
    this.babyEye = new Image();  //眼睛
    this.babyBody = new Image(); //身体
    this.babyTail = new Image(); //尾巴
    this.angle; //鱼的角度
};

babyObj.prototype.init = function () {
    this.x = canWidth * 0.5 - 50;
    this.y = canHeight * 0.5 + 50;
    this.babyEye.src = "../../static/image/babyEye0.png";
    this.babyBody.src = "../../static/image/babyFade0.png";
    this.babyTail.src = "../../static/image/babyTail0.png";
    this.angle = 0;
};

babyObj.prototype.draw = function () {
    //把小鱼放到一个单独的环境

    this.x = lerpDistance(mom.x, this.x, 0.98); //第三个参数，控制🐟跟随鼠标的速度
    this.y = lerpDistance(mom.y, this.y, 0.98);

    //设置鱼的角度
    var deltaY = mom.y - this.y;
    var deltaX = mom.x - this.x;

    var beta = Math.atan2(deltaY,deltaX) + Math.PI;

    this.angle = lerpAngle(beta,this.angle,0.6);
    ctx1.save();
    ctx1.translate(this.x,this.y);
    ctx1.rotate(this.angle); //将矩形旋转多少度：
    ctx1.drawImage(this.babyTail,-this.babyTail.width * 0.5 + 23 ,-this.babyTail.height * 0.5);
    ctx1.drawImage(this.babyBody,-this.babyBody.width * 0.5 ,-this.babyBody.height * 0.5);
    ctx1.drawImage(this.babyEye,-this.babyEye.width * 0.5 ,-this.babyEye.height * 0.5); //-this.bigEye.width * 0.5为了让图片在远点的中央
    ctx1.restore();
};