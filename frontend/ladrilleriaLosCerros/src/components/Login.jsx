import { useState } from 'react';
import { CiLock, CiUser } from 'react-icons/ci';
import logoCerros from '../utils/pintures/logo-los-cerros.webp'

export function Login() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const handleLogin = (e) => {
    e.preventDefault();
    // Aquí podrías añadir la lógica para el login
    console.log(`Username: ${username}, Password: ${password}`);
  };

  return (
    <main className="h-screen flex justify-center items-center bg-background font-Montserrat">
      <div className="bg-contrast p-8 rounded-lg shadow-lg w-96">
        <div className="pinture-container-custom flex justify-center mb-6">
          <img className="pinture-custom" src={logoCerros} alt="logo" />
        </div>
        <form onSubmit={handleLogin} className="flex flex-col gap-5">
          <div className="flex flex-col">
            <label className="text-black" htmlFor="username">Username</label>
            <div className="flex items-center border-b-2 border-black-300 py-2">
              <CiUser className="text-black mr-2 scale-150" />
              <input
                className="bg-transparent outline-none w-full text-black"
                type="text"
                id="username"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
                required
              />
            </div>
          </div>
          <div className="flex flex-col">
            <label className="text-black" htmlFor="password">Password</label>
            <div className="flex items-center border-b-2 border-gray-300 py-2">
              <CiLock className="text-black mr-2 scale-150" />
              <input
                className="bg-transparent outline-none w-full text-black"
                type="password"
                id="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required
              />
            </div>
          </div>
          <button type="submit" className="bg-primary text-black p-3 rounded-lg hover:bg-secondary">
            Log In
          </button>
        </form>
      </div>
    </main>
  );
}