import '../style/App.css'
import losCerros from '../utils/pintures/logo-los-cerros.webp'
import { TfiBlackboard } from "react-icons/tfi";
import { AiFillProduct } from "react-icons/ai";
import { IoPersonOutline } from "react-icons/io5";
import { MdPointOfSale } from "react-icons/md";
import { CiMoneyCheck1 } from "react-icons/ci";
import { RiMoneyDollarCircleLine } from "react-icons/ri";
import { FaPiggyBank } from "react-icons/fa";
import { FaShoppingCart } from "react-icons/fa";

import Chart  from 'chart.js/auto'

const data = [
  { year: 2010, count: 10 },
  { year: 2011, count: 20 },
  { year: 2012, count: 15 },
  { year: 2013, count: 25 },
  { year: 2014, count: 22 },
  { year: 2015, count: 30 },
  { year: 2016, count: 28 },
];

new Chart(
  document.getElementById('acquisitions'),
  {
    type: 'bar',
    data: {
      labels: data.map(row => row.year),
      datasets: [
        {
          label: 'Acquisitions by year',
          data: data.map(row => row.count)
        }
      ]
    }
  }
);
const Item = ({ children }) => {
  return (
    <div className="item">{children}</div>
  );
}

export function Menu() {
  return (
    <main className="home">
      <aside className="aside">
        <header className="header">
          <div className="pintureContainer">
            <img className="pinture" src={losCerros} alt="logo" />
          </div>
          <nav>
            <ul className="nav">
              <Item><TfiBlackboard className='icon' />Panel</Item>
              <Item><AiFillProduct className='icon' />Productos</Item>
              <Item><IoPersonOutline className='icon' />Clientes</Item>
              <Item><MdPointOfSale className='icon' />Ingreso</Item>
              <Item><CiMoneyCheck1 className='icon' />Cartera</Item>
            </ul>
          </nav>
        </header>
        <footer className='footer'>
          <div className='avatarContainer'></div>
          <div className='text'>Username</div>
        </footer>
      </aside>
      <section className='content'>
       
        <section className='resume'>
          <div className='container'>
            <div className='iconContainerMoney'style={{ backgroundColor: '#E3FCEE',color:'#1E9E5E'}} >
              <RiMoneyDollarCircleLine />
            </div>
            <div>
              <h5>Ganancias</h5>
              <h3>$1000</h3>
              <h6>$50 al mes</h6>
            </div>
          </div>
          <div className='container'>
            <div className='iconContainerBank' style={{ backgroundColor: '#CFF4FE',color:'#326C92' }}>
              <FaPiggyBank />
            </div>
            <div>
              <h5>Ganancias</h5>
              <h3>$1000</h3>
              <h6>$50 al mes</h6>
            </div>
          </div>
          <div className='container'>
            <div className='iconContainerShop' style={{ backgroundColor: '#FECAF2',color:'#E76899'}}>
              <FaShoppingCart />
            </div>
            <div>
              <h5>Ganancias</h5>
              <h3>$1000</h3>
              <h6>$50 al mes</h6>
            </div>
          </div>
        </section>

        <section className='details'>
          <div className='grafict' id='grafict'>
            Informe de ventas por año
          </div>
          <div className='clients'>Porcentaje de clientes</div>
          <div className='products'>Historial de productos Vendidos</div>
        </section>
      </section>
    </main>
  );
}