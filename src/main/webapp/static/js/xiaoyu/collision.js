//判断果实和🐟的距离
function momFruitsCollisiom() {

    for(var i = 0; i<fruit.num; i++){

        if(fruit.alive[i]){

           var l = calLength2(fruit.x[i],fruit.y[i],mom.x,mom.y);
           if(l < 900){
               fruit.dead(i);
           }
        }
    }
}