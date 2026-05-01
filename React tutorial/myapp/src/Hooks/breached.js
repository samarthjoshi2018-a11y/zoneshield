import { useEffect, useState, useRef } from "react";
import { setBreached } from "../features/slices/authSlice";
import { useSelector, useDispatch } from "react-redux";
import api from "../api/api";

export const breached = () => {
    const dispatch = useDispatch();
    const { locked, breached, email, firstEmail, secondEmail, thirdEmail } = useSelector((state) => state.auth);

    const [cooldown, setCooldown] = useState(false);
    const timerRef = useRef(null); // ✅ persists across renders

    useEffect(() => {
        // 🔴 If unlocked → clear everything
        if (!locked) {
            if (timerRef.current) {
                clearTimeout(timerRef.current);
                timerRef.current = null;
            }
            setCooldown(false);
            return;
        }

        if (cooldown || !breached) return;

        const run = async () => {
            try {
                console.log("Breach detected and executing cooldown logic");

                await api.post("/userinfo/breached",{
                    email,
                    firstEmail:firstEmail,
                    secondEmail:secondEmail,
                    thirdEmail:thirdEmail
                });

                setCooldown(true);

                timerRef.current = setTimeout(() => {
                    console.log("Cooldown finished");
                    setCooldown(false);
                    timerRef.current = null;
                }, 5 * 60 * 1000);

                dispatch(setBreached(false));

            } catch (err) {
                console.error("Error resetting breach status:", err);
            }
        };

        run();

        return () => {
            if (timerRef.current) {
                clearTimeout(timerRef.current);
                timerRef.current = null;
            }
        };

    }, [locked, breached, cooldown, dispatch]);
};