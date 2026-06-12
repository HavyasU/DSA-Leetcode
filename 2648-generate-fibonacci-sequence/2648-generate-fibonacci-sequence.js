/**
 * @return {Generator<number>}
 */

let f1 = 0;
let f2 = 1;
let f3;

var fibGenerator = function*() {
    let a=0,b=1;


   while(true){
     yield a;
    let c = a+b;
    a=b;
    b=c;
   }
};

/**
 * const gen = fibGenerator();
 * gen.next().value; // 0
 * gen.next().value; // 1
 */