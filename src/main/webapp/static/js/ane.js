var aneObj = function () {
    this.x =[];
    this.len = []
};
aneObj.prototype.num = 50;
aneObj.prototype.init = function () {

        for(var i = 0; i<this.num; i++){
            this.x[i] = i * 16 + Math.random() * 20; //[0,1]
            this.len[i] = 200 + Math.random() * 50;
        }
};

aneObj.prototype.draw = function () {


    ctx2.save();//save()
    ctx2.globalAlpha = "0.6";//设置或返回绘图的当前 alpha 或透明值
    for(var i = 0; i<this.num; i++){
        ctx2.beginPath();//	起始一条路径，或重置当前路径
        ctx2.moveTo(this.x[i],canHeight);//把路径移动到画布中的指定点，不创建线条
        ctx2.lineTo(this.x[i],canHeight - this.len[i]); //添加一个新点，然后在画布中创建从该点到最后指定点的线条
        ctx2.lineWidth = 20;
        ctx2.lineCap = "round";
        ctx2.strokeStyle = "#3d1541";
        ctx2.stroke()
    }
    ctx2.restore();
};