/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function(init) {
    var number = init;
    return {
        increment:()=>{
            return ++number;
        },
        decrement:()=>{
            return --number;
        },
        reset:()=>{
            return number=init;
        }
    }
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */