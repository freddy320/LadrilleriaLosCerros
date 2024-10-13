import { CiBadgeDollar, CiShoppingCart, CiCalculator1 } from "react-icons/ci";
import { Children } from "react";
import { Line } from "react-chartjs-2"
import { Chart as ChartJs, CategoryScale, LinearScale, PointElement, LineElement, Tooltip, Legend, Title } from "chart.js";
import Filtros from "./panel/Filtros";
ChartJs.register(CategoryScale, LinearScale, PointElement, LineElement, Tooltip, Legend, Title);



const CardProduct = ({nombre,Unidades,totalRecaudo})=>{
    return(
        <div className="bg-contrast p-4 rounded-xl shadow-md"> 
            <h3 className="font-bold text-lg">{nombre}</h3>
            <p className="text-sm opacity-65">{Unidades}</p>
            <h6 className="text-lg font-bold">{totalRecaudo}</h6>      
        </div>
    )
}


const CardContainer = ({ children }) => {
    return (
        <div className="grid grid-cols-3 grid-cols-gridGraficts h-28">
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

export default function Panel() {
    return (
        <main className="flex h-full gap-4">
            <div className="flex flex-col gap-4 w-4/5">
                <section className='flex gap-8 justify-center bg-contrast p-4 rounded-xl shadow-lg'>
                    <ItemPanel title="Ganancias" resultText="$50 en el último mes" result="$ 1000" icon={<CiBadgeDollar className="w-12 h-12" />} />
                    <ItemPanel title="Promedio" resultText="+ 1.5 de ventas en el último mes" result="50.5" icon={<CiCalculator1 className="w-12 h-12" />} />
                    <ItemPanel title="Ventas" resultText="+ 50 ventas en el último mes" result="1000" icon={<CiShoppingCart className="w-12 h-12" />} />
                </section>


                <section className="grid grid-cols-gridGraficts grid-cols-1 gap-2">
                <section className='grid grid-cols-2 gap-2'>
                    <div className='bg-contrast px-5 py-2 rounded-xl shadow-lg'>
                        <header className="flex justify-between items-baseline">
                            <h2 className="font-extrabold text-xl">Informe general de ventas</h2>
                        </header>
                        <div>
                            <LineChart />
                        </div>
                    </div>

                    <div className='bg-contrast px-5 py-2 rounded-xl shadow-lg'>
                        <h2 className="font-semibold text-xl">Clientes</h2>
                    </div>
                </section>
                <section className="h-full bg-contrast px-5 py-2 rounded-xl shadow-lg">
                    <header><h2 className="font-extrabold text-xl">Productos vendidos</h2></header>
                    <div className="grid gap-2 overflow-y-scroll py-1">
                       
                            <CardProduct nombre="Ladrillo" Unidades="1000 unidades" totalRecaudo="$ 1000" />
                            <CardProduct nombre="Cemento" Unidades="1000 unidades" totalRecaudo="$ 1000" />
                            <CardProduct nombre="Arena" Unidades="1000 unidades" totalRecaudo="$ 1000" />
                    </div>
                </section>
                </section>
                
            </div>

            
            <section className="w-1/5 bg-contrast p-4 rounded-xl shadow-lg">
            <h3 className="font-bold text-base">Filtros</h3>
                <Filtros />
            </section>
        </main>


    )
}
