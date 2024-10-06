import { RiMoneyDollarCircleLine } from "react-icons/ri";
import { FaPiggyBank, FaShoppingCart } from "react-icons/fa";
import { useState } from "react";
import { SlArrowDown } from "react-icons/sl";
import { Bar } from "react-chartjs-2";


const shopData = [
    {
        id: 1,
        name: 'Ladrillo',
        price: 100,
        year:2024
    },

    {
        id: 2,
        name: 'Cemento',
        price: 200,
        year:2024
    }

];

function Barchar(shopData){
    return (
        <Bar
            data={{
                shopData
            }}
        />
    )
}


const ComboBox = ({opcions}) => {
    const [isActive, setActive] = useState(false);
    const hancleClick = () => setActive(!isActive);
    return (
        <div className="flex flex-col">
            <div onClick={hancleClick} className="flex justify-center rounded-xl transition duration-500 bg-background items-center w-24 gap-3 p-2 font-medium hover:bg-red-300 hover:text-contrast ">
                {opcions[0]}<SlArrowDown />
            </div>
        </div>
    )
}

export default function Panel() {
    return (
        <div className="flex flex-col gap-4 h-full">
            <section className='flex gap-8 justify-center bg-contrast p-4 rounded-xl'>
                <div className='flex gap-2 items-center'>
                    <div className='w-20 h-20  rounded-full flex items-center justify-center bg-green-100 text-green-800'>
                        <RiMoneyDollarCircleLine className="w-12 h-12" />
                    </div>
                    <div>
                        <h5 className="text-lg opacity-65">Ganancias</h5>
                        <h2 className="text-3xl font-extrabold">$1000</h2>
                        <h6 className="text-sm">$50 en el útlimo mes</h6>
                    </div>
                </div>
                <div className='flex gap-2 items-center'>
                    <div className='w-20 h-20  rounded-full flex items-center justify-center  bg-cyan-100 text-sky-800'>
                        <FaPiggyBank className="w-12 h-12" />
                    </div>
                    <div>
                        <h5 className="text-lg opacity-65">Promedio</h5>
                        <h2 className="text-3xl font-bold">$500</h2>
                        <h6 className="text-sm">$50 en el útlimo mes</h6>
                    </div>
                </div>
                <div className='flex gap-2 items-center'>
                    <div className='w-20 h-20  rounded-full flex items-center justify-center bg-fuchsia-100 text-fuchsia-800'>
                        <FaShoppingCart className="w-12 h-12" />
                    </div>
                    <div>
                        <h5 className="text-lg opacity-65">Ventas totales</h5>
                        <h2 className="text-3xl font-bold">$1000</h2>
                        <h6 className="text-sm">$50 en el útlimo mes</h6>
                    </div>
                </div>
            </section>

            <section className='grid grid-cols-2 gap-7 h-full'>
                <div className='bg-contrast px-5 py-2 rounded-xl' >
                    <header className="flex justify-between items-baseline">
                    <div>
                    <h2 className="font-extrabold text-xl">Informe de ventas por año</h2>
                    <h5>Comparación de ventas por año</h5>
                    </div>
                    <ComboBox opcions={['2024','2023','2022','2021']} />
                    
                    </header>
                </div>
                <div className='bg-contrast px-5 py-2 rounded-xl'> 
                    <h2 className="font-extrabold text-xl">Clientes</h2>
                    <h5>Porcentajes de clientes fidelizados por venta</h5>
                </div>
            </section>

            <section>
                <div className='h-96 bg-contrast px-5 py-2 rounded-xl '>
                    <h2 className="font-extrabold text-xl">Productos</h2>
                    <h5>Productos o Servivios mas vendidos</h5>
                    </div>
            </section>
        </div>
    )
}
