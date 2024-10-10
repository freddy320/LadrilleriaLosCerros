import { CiBadgeDollar, CiShoppingCart, CiCalculator1 } from "react-icons/ci";
import { Children, useState } from "react";
import { BiSolidDownArrow } from "react-icons/bi";
import {Line} from "react-chartjs-2"
import { Chart as ChartJs, CategoryScale, LinearScale,PointElement,LineElement,Tooltip,Legend,Title } from "chart.js";
ChartJs.register(CategoryScale, LinearScale,PointElement,LineElement,Tooltip,Legend,Title);


const CardContainer = ({ children }) => {
    return (
        <div className="bg-contrast p-4 rounded-xl shadow-lg">
            {children}
        </div>
    )
}






const lineCharData = {
    labels: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio'],
    datasets: [
        {
            
            label: 'Numero de ventas',
            data: [12, 19, 3, 5, 2, 3, 10],
            borderColor: "#EA8373",
        },

    ],
}


const LineChart = () => {
    return (
        <div className="bg-contrast p-4 rounded-xl shadow-lg">
            <Line data={lineCharData} />
        </div>
    )
}

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
        <div className="flex flex-col absolute top-0 right-0 mx-5 my-2">
            {
                isActive ? opcions.map((opc) => (
                    <div onClick={() => handleClick(opc)} key={opc} className="flex justify-center rounded-xl transition duration-500 bg-themePage items-center w-24 gap-3 p-2 font-medium text-contrast  cursor-pointer hover:bg-themePageDark">
                        {opc}<BiSolidDownArrow />
                    </div>
                ))
                    :
                    <div onClick={() => setActive(!isActive)} className="flex justify-center rounded-xl transition duration-500 bg-themePage items-center w-24 gap-3 p-2 font-medium hover:bg-themePage text-contrast cursor-pointer hover:bg-themePageDark">
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
                <ItemPanel title="Ganancias" resultText="$50 en el útlimo mes" result="$ 1000" icon={<CiBadgeDollar className="w-12 h-12" />} />
                <ItemPanel title="Promedio" resultText="+ 1.5 de ventas en el utlimo mes" result="50.5" icon={<CiCalculator1 className="w-12 h-12" />} />
                <ItemPanel title="Ventas" resultText="+ 50 ventas en el ultimo mes" result="1000" icon={<CiShoppingCart className="w-12 h-12" />} />
            </section>

            <section className='grid grid-cols-2  grid-rows-graficsPanel gap-2  overflow-visible'>
                <div className='bg-contrast px-5 py-2 rounded-xl   shadow-lg relative'  >
                    <header className="flex justify-between items-baseline h-auto">
                        <div>
                            <h2 className="font-extrabold text-xl">Informe general de ventas</h2>
                        </div>
                        <ComboBox opcions={['2024', '2023', '2022', '2021']} />
                    </header>
                    <div>
                    <LineChart />
                    </div>
                    
                </div>
                <div className='bg-contrast px-5 py-2 rounded-xl h-auto shadow-lg'>
                    <h2 className="font-semibold text-xl">Clientes</h2>
                   
                </div>
            </section>


        </div>
    )
}
