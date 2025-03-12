import { FaEye, FaEyeSlash, FaGoogle } from "react-icons/fa";
import { Link, useLocation, useNavigate } from "react-router-dom";
import { useState, useContext } from "react";
import toast, { Toaster } from "react-hot-toast";
import { AuthContext } from "../../Providers/AuthProvider";

const Login = () => {
  const location = useLocation();
  const navigate = useNavigate();
  const [showPassword, setShowPassword] = useState(false);
  const [loading, setLoading] = useState(false);
  const { signIn } = useContext(AuthContext);

  const handleLogin = async (e) => {
    e.preventDefault();
    setLoading(true);

    const form = new FormData(e.currentTarget);
    const email = form.get("email");
    const password = form.get("password");

    try {
      const userCredential = await signIn(email, password);
      console.log("User logged in: ", userCredential.user);
      toast.success("Login successful!");
      navigate(location?.state ? location.state : "/");
      setTimeout(() => {
        window.location.reload();
      }, 500);
    } catch (error) {
      console.error("Login error: ", error);
      toast.error("Login failed! Invalid credentials.");
    }

    setLoading(false);
  };

  return (
    <div>
      <div className="py-12">
        <h1 className="mx-auto pt-5 text-5xl text-center font-extrabold uppercase text-[#db2d2e]">
          Please Login
        </h1>

        {/* Login Form */}
        <form onSubmit={handleLogin} className="card-body text-center lg:w-1/2 md:h-3/4 mx-auto">
          <div className="form-control">
            <label className="input-group w-full">
              <span className="w-1/3">Email</span>
              <input type="email" name="email" placeholder="Your Email" className="input input-bordered w-full" required />
            </label>
          </div>

          <div className="form-control">
            <label className="input-group w-full">
              <span className="w-1/3">Password</span>
              <input
                type={showPassword ? "text" : "password"}
                name="password"
                placeholder="Your Password"
                className="input input-bordered w-full"
                required
              />
              <span className="absolute mt-3 lg:ml-[550px] ml-[305px] bg-white text-xl cursor-pointer" onClick={() => setShowPassword(!showPassword)}>
                {showPassword ? <FaEyeSlash /> : <FaEye />}
              </span>
            </label>
            <label className="label">
              <a href="#" className="label-text-alt link link-hover">
                Forgot password?
              </a>
            </label>
          </div>

          <div className="form-control mt-6">
            <button type="submit" className="btn bg-[#ce1446] text-white font-bold hover:text-[#ce1446]" disabled={loading}>
              {loading ? "Logging in..." : "Login"}
            </button>
          </div>
          <Toaster />
        </form>

        

        <p className="text-center">
          Do not have an Account?{" "}
          <Link to="/register" className="text-blue-600 underline">
            Register
          </Link>
        </p>
      </div>
    </div>
  );
};

export default Login;