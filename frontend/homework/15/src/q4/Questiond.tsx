import React, { useState, useEffect } from 'react';

const Questiond: React.FC = () => {
    const [seconds, setSeconds] = useState<number>(0);
    const [isActive, setIsActive] = useState<boolean>(false);

    useEffect(() => {
        let interval: NodeJS.Timeout | null = null;
        if (isActive) {
            interval = setInterval(() => {
                setSeconds(prevSeconds => prevSeconds + 1);
            }, 1000);
        } else if (interval) {
            clearInterval(interval);
        }
        return () => {
            if (interval) clearInterval(interval);
        };
    }, [isActive]);

    const toggleTimer = () => {
        setIsActive(prevIsActive => !prevIsActive);
    };

    const resetTimer = () => {
        setSeconds(0);
        setIsActive(false);
    };

    return (
        <div>
            <p> USE REF QUESTION 4</p>
            <h1>Timer: {seconds}s</h1>
            <button onClick={toggleTimer}>{isActive ? 'Pause' : 'Start'}</button>
            <button onClick={resetTimer}>Reset</button>
        </div>
    );
};

export default Questiond;
