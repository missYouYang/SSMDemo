var friutObj = function(){
    this.alive = [];  //boolean  确定海葵是否存活
    this.orange = new Image(); //橘色海葵
    this.blue = new Image(); //绿色海葵
    this.x = [];
    this.y = [];
    this.l = [];
    this.spd = [];
    this.fruitType = [];
};
friutObj.prototype.num = 30;
friutObj.prototype.init = function () {

    //给海葵一个默认的存活状态
    for(var i = 0; i<this.num; i++){

        this.alive[i] = false;
        this.x[i] = 0;
        this.y[i] = 0;
        this.spd[i] = Math.random() * 0.017 + 0.003;//[0.01,0.015]
        this.fruitType[i] = "";
    }
    //默认图片
    this.orange.src = "../../static/image/fruit.png";
    this.blue.src = "../../static/image/blue.png";
};

//海葵的针(出生的地方)
friutObj.prototype.draw = function () {
    for(var i = 0; i<this.num; i++){

        if(this.fruitType[i] == 'blue'){
            var pic = this.blue;
        }else{
            var pic = this.orange;
        }
        //如果存活执行
        if(this.alive[i]){
            //改变海葵的y，使海葵上浮
            if(this.l[i] <= 14){
                this.l[i] += this.spd[i] * deltaTime;
            }else{
                this.y[i] -=this.spd[i] * 7 * deltaTime;
            }
            ctx2.drawImage(pic,this.x[i] - this.l[i] * 0.5 ,this.y[i]-this.l[i] * 0.5,this.l[i] ,this.l[i]);
            if(this.y[i] < 10){
                this.alive[i] = false;
            }
        }
    }
};

//海葵的坐标(出生的地方)
friutObj.prototype.born = function (i) {
    var aneID = Math.floor(Math.random() * ane.num);
    this.x[i] = ane.x[aneID];    //海葵的x坐标
    this.y[i] = canHeight - ane.len[aneID];       //海葵的y坐标
    this.l[i] = 0;  //在出生的时候长度
    this.alive[i] = true;
    var ran = Math.random();
    if(ran<0.2){
        this.fruitType[i] = "blue";
    }else{
        this.fruitType[i] = "orange";
    }
};
//鱼的死亡
friutObj.prototype.dead = function (i) {
    this.alive[i] = false;
};


//作为检测海葵的数量
function fruitMonitor() {

    var num = 0;
    //不停的循环，判断存活的总数量
    for(var i = 0; i<fruit.num; i++){

        if(fruit.alive[i]) num ++;
    }

    //如果小于15个添加新的，并且结束当前
    if(num < 15){
        setFruit();
        return;
    }
}

//添加新的果实
function setFruit() {
    for(var i = 0; i<fruit.num; i++){

        //如果当前为false，则新生一个海葵，结束当前循环
        if(!fruit.alive[i]){
            fruit.born(i);
            return;
        }
    }
}


