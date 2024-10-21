
import losCerros from '../utils/pintures/logo-los-cerros.webp';
import { TfiBlackboard } from "react-icons/tfi";
import { AiFillProduct } from "react-icons/ai";
import { IoPersonOutline } from "react-icons/io5";
import { MdPointOfSale } from "react-icons/md";
import { CiMoneyCheck1 } from "react-icons/ci";
import { CiSettings } from "react-icons/ci";
import { TfiAnnouncement } from "react-icons/tfi";
import Panel from './Panel';
// import { Ventas } from './Ventas';
import { Cartera } from './Cartera';

const Item = ({children}) => {
  return (
    <div className="flex gap-3 rounded-xl transition duration-500 items-center px-5 py-2 cursor-pointer  hover:bg-themePage hover:text-contrast ">
      {children}
    </div>
  );
};

export function Menu() {
  return (
    <main className="h-screen grid grid-cols-home font-Montserrat bg-background ">
      <aside className="flex flex-col justify-between gap-3rounded-s bg-contrast p-1 shadow-lg">
        <header className="flex flex-col gap-5">
          <div className="pinture-container-custom">
            <img className="pinture-custom" src={losCerros} alt="logo" />
          </div>
          <nav>
            <ul className="flex flex-col gap-2">
              <Item><TfiBlackboard className='scale-150 w-5 h-5' />Panel</Item>
              <Item><AiFillProduct className='scale-150 w-5 h-5' />Productos</Item>
              <Item><IoPersonOutline className='scale-150 w-5 h-5' />Clientes</Item>
              <Item><MdPointOfSale className='scale-150 w-5 h-5' />Ventas</Item>
              <Item><CiMoneyCheck1 className='scale-150 w-5 h-5' />Cartera</Item>
              <Item><TfiAnnouncement className='scale-150 w-5 h-5' />Anuncios</Item>
            </ul>
          </nav>
        </header>
        <footer className='flex justify-center items-center gap-2 p-2'>
          <div className='w-10 h-10 bg-black rounded-full'></div>
          <div className='flex gap-2 items-center'>Username <CiSettings  className='scale-150'/></div>
        </footer>
      </aside>
      <section className='overflow-scroll p-2'>
       {/* <Panel /> */}
       <Cartera />
      </section>
    </main>
  );
}
