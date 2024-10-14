
import { Route, Routes } from "react-router-dom";
import { Menu } from "./components/menu";
import { Login } from "./components/login";
function App() {
  return (
    <section className="app">
        <Routes>
          <Route path="/"element={<Login />} />
          <Route path="/panel" element={<Menu  />} />
          <Route path="/anuncios" element={<Menu/>} />
        </Routes>
    </section>
  );
}

export default App;