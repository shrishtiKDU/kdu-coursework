import React, { useRef, useEffect } from 'react';

const Questionc: React.FC = () => {
    const firstInputRef = useRef<HTMLInputElement>(null);

    useEffect(() => {
        if (firstInputRef.current) {
            firstInputRef.current.focus();
        }
    }, []); 

    return (
        <form>
            <p> USE REF QUESTION 3 </p>
            <label htmlFor="firstName">First Name:</label>
            <input id="firstName" type="text" ref={firstInputRef} />

            <label htmlFor="lastName">Last Name:</label>
            <input id="lastName" type="text" />

            <label htmlFor="email">Email:</label>
            <input id="email" type="email" />

            {/* Additional form fields */}

            <button type="submit">Submit</button>
        </form>
    );
};

export default Questionc;
