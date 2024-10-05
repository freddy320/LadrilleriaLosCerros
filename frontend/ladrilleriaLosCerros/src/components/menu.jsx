import '../style/App.css'
import losCerros from '../utils/pintures/logo-los-cerros.webp'
import { TfiBlackboard } from "react-icons/tfi";
import { AiFillProduct } from "react-icons/ai";
import { IoPersonOutline } from "react-icons/io5";


export  function Menu() {
    return (
        <main className="home">
          <aside className ="aside">
            <header className = "header">
              <div className = "pintureContainer" >
                <img className="pinture"  src = {losCerros} alt = "logo" /> 
              </div>
              <nav >
                <ul className = "nav">
                  <li className = "item">Panel <TfiBlackboard /></li>
                  <li className = "item">Productos <AiFillProduct /></li>
                  <li className = "item">Clientes <IoPersonOutline /></li>
                  <li className = "item">Ingreso</li>
                  <li className = "item">Promote</li>
                  <li className = "item">Help</li>
                </ul>
            </nav>
            </header>
            <footer>
              <section>
                <div>Usename</div>
              </section>
            </footer>
          </aside>
          <section>
            <header>
              <h2>Hello bienvenido!</h2>
            </header>
          </section>
        </main>
      )
}