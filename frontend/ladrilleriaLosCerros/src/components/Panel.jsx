import { CiBadgeDollar, CiShoppingCart, CiCalculator1 } from "react-icons/ci";
import { useState } from "react";
import { SlArrowDown } from "react-icons/sl";

const ItemPanel = ({ title, resultText, result, icon }) => {
    return (
        <div className='flex gap-2 items-center'>
            <div className={`w-20 h-20 rounded-full flex items-center justify-center bg-themePage text-contrast`}>
                {icon}
            </div>
            <div>
                <h5 className="text-lg opacity-65">{title}</h5>
                <h2 className="text-3xl font-extrabold">${result}</h2>
                <h6 className="text-sm opacity-65 font-bold">{resultText}</h6>
            </div>
        </div>
    )
}

const ComboBox = ({ opcions }) => {
    const [isActive, setActive] = useState(false);
    const handleClick = () => setActive(!isActive);
    return (
        <div className="flex flex-col">
            <div onClick={handleClick} className="flex justify-center rounded-xl transition duration-500 bg-background items-center w-24 gap-3 p-2 font-medium hover:bg-red-300 hover:text-contrast ">
                {opcions[0]}<SlArrowDown />
            </div>
        </div>
    )
}

export default function Panel() {
    return (
        <div className="flex flex-col gap-4 h-full">
            <section className='flex gap-8 justify-center bg-contrast p-4 rounded-xl'>
                <ItemPanel title="Ganancias" resultText="$50 en el útlimo mes" result="1000" icon={<CiBadgeDollar className="w-12 h-12" />}/>
                <ItemPanel title="Promedio" resultText="+ 1.5 de ventas en el utlimo mes" result="500" icon={<CiCalculator1 className="w-12 h-12" />}/>
                <ItemPanel title="Ventas" resultText="+ 50 ventas en el ultimo mes" result="1000" icon={<CiShoppingCart  className="w-12 h-12" />}/>
            </section>

            <section className='grid grid-cols-2 gap-7 h-full'>
                <div className='bg-contrast px-5 py-2 rounded-xl' >
                    <header className="flex justify-between items-baseline">
                        <div>
                            <h2 className="font-extrabold text-xl">Informe de ventas por año</h2>
                            <h5>Comparación de ventas por año</h5>
                        </div>
                        <ComboBox opcions={['2024', '2023', '2022', '2021']} />
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
