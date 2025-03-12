/* eslint-disable react/prop-types */

import { useContext, useEffect, useState } from "react";
import { AuthContext } from "../Providers/AuthProvider";
import { Navigate, useLocation } from "react-router-dom";

const PrivateRoutes = ({ children }) => {
    const { user, loading } = useContext(AuthContext);
    const location = useLocation();
    const [userRole, setUserRole] = useState(localStorage.getItem("userRole"));

    useEffect(() => {
        setUserRole(localStorage.getItem("userRole")); // ✅ Ensure role is updated on refresh
    }, []);

    console.log("Current Path:", location.pathname);
    console.log("User Role:", userRole);

    if (loading) {
        return <span className="loading loading-infinity loading-lg"></span>;
    }

    // ✅ Allow access if normal user is logged in
    if (user) {
        return children;
    }

    // ✅ Allow Admin to access /addProducts
    if (userRole === "admin" && location.pathname === "/addProducts") {
        return children;
    }

    // ❌ Otherwise, Redirect to Login
    return <Navigate state={location.pathname} to="/login" replace />;
};

export default PrivateRoutes;
