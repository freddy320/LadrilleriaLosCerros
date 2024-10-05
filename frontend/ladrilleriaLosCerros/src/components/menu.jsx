import '../style/App.css';
import losCerros from '../utils/pintures/logo-los-cerros.webp';
import { TfiBlackboard } from "react-icons/tfi";
import { AiFillProduct } from "react-icons/ai";
import { IoPersonOutline } from "react-icons/io5";
import { MdPointOfSale } from "react-icons/md";
import { CiMoneyCheck1 } from "react-icons/ci";

import Chart from 'chart.js/auto';
import Panel from './Panel';

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
    <div className="item-custom">{children}</div>
  );
};

export function Menu() {
  return (
    <main className="home-custom">
      <aside className="aside-custom">
        <header className="header-custom">
          <div className="pinture-container-custom">
            <img className="pinture-custom" src={losCerros} alt="logo" />
          </div>
          <nav>
            <ul className="nav-custom">
              <Item><TfiBlackboard className='icon-custom' />Panel</Item>
              <Item><AiFillProduct className='icon-custom' />Productos</Item>
              <Item><IoPersonOutline className='icon-custom' />Clientes</Item>
              <Item><MdPointOfSale className='icon-custom' />Ingreso</Item>
              <Item><CiMoneyCheck1 className='icon-custom' />Cartera</Item>
            </ul>
          </nav>
        </header>
        <footer className='footer-custom'>
          <div className='avatar-container-custom'></div>
          <div className='text'>Username</div>
        </footer>
      </aside>
      <section className='content-custom'>
       <Panel />
      </section>
    </main>
  );
}
