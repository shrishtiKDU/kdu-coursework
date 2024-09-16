import React, { useRef } from "react";

const Questiona= () => {
    const count = useRef<number>(0);

    const handleChange = () => {
        count.current += 1;
        console.log(count.current);
    };

    return (
        <>
        <p> Use ref question 1</p>
            <h1>Count value: {count.current}</h1>
            <button onClick={handleChange}>
                <span>+</span>
            </button>
        </>
    );
};

export default Questiona;