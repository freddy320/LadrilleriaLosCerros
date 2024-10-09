
import { Route, Routes } from "react-router-dom";
import { Menu } from "./components/menu";
function App() {
  return (
    <section className="app">
        <Routes>
          <Route path="/"element={<Menu />} />
          <Route path="/panel" element={<Menu  />} />
        </Routes>
    </section>
  );
}

export default App;