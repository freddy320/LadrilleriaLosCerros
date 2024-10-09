import { CiBadgeDollar, CiShoppingCart, CiCalculator1 } from "react-icons/ci";
import { useState } from "react";
import { SlArrowDown } from "react-icons/sl";
import { BiSolidDownArrow } from "react-icons/bi";

const ItemPanel = ({ title, resultText, result, icon }) => {
    return (
        <div className='flex gap-2 items-center'>
            <div className={`w-20 h-20 rounded-full flex items-center justify-center bg-themePage text-contrast`}>
                {icon}
            </div>
            <div>
                <h5 className="text-lg opacity-65">{title}</h5>
                <h2 className="text-3xl font-extrabold px-1">{result}</h2>
                <h6 className="text-sm opacity-65 font-bold">{resultText}</h6>
            </div>
        </div>
    )
}

const ComboBox = ({ opcions }) => {
    const [isActive, setActive] = useState(false);
    const [selected, setSelected] = useState(opcions[0]);
    const handleClick = (value) => {
        setActive(!isActive);
        setSelected(value);
    }
    return (
        <div className="flex flex-col">
           {
            isActive ? opcions.map((opc) => (
                <div onClick={() => handleClick(opc)} key={opc} className="flex justify-center rounded-xl transition duration-500 bg-themePage items-center w-24 gap-3 p-2 font-medium text-contrast  cursor-pointer hover:bg-red-500">
                    {opc}<BiSolidDownArrow />
                </div>
            ))
                : 
            <div onClick={() => setActive(!isActive)} className="flex justify-center rounded-xl transition duration-500 bg-themePage items-center w-24 gap-3 p-2 font-medium hover:bg-themePage text-contrast cursor-pointer hover:bg-red-500">
                {selected}<BiSolidDownArrow />
            </div>
           }
        </div>
    )
}

export default function Panel() {
    return (
        <div className="flex flex-col gap-4 h-full">
            <section className='flex gap-8 justify-center bg-contrast p-4 rounded-xl shadow-lg'>
                <ItemPanel title="Ganancias" resultText="$50 en el útlimo mes" result="$ 1000" icon={<CiBadgeDollar className="w-12 h-12" />}/>
                <ItemPanel title="Promedio" resultText="+ 1.5 de ventas en el utlimo mes" result="50.5" icon={<CiCalculator1 className="w-12 h-12" />}/>
                <ItemPanel title="Ventas" resultText="+ 50 ventas en el ultimo mes" result="1000" icon={<CiShoppingCart  className="w-12 h-12" />}/>
            </section>

            <section className='grid grid-cols-2 gap-7 h-24 overflow-visible'>
                <div className='bg-contrast px-5 py-2 rounded-xl  h-24 shadow-lg'  >
                    <header className="flex justify-between items-baseline h-auto">
                        <div>
                            <h2 className="font-extrabold text-xl">Informe de ventas por año</h2>
                            <h5>Comparación de ventas por año</h5>
                        </div>
                        <ComboBox opcions={['2024', '2023', '2022', '2021']} />
                    </header>
                </div>
                <div className='bg-contrast px-5 py-2 rounded-xl h-auto shadow-lg'>
                    <h2 className="font-extrabold text-xl">Clientes</h2>
                    <h5>Porcentajes de clientes fidelizados por venta</h5>
                </div>
            </section>

            
        </div>
    )
}
