import { RiMoneyDollarCircleLine } from "react-icons/ri";
import { FaPiggyBank, FaShoppingCart } from "react-icons/fa";

export default function Panel() {
    return (
        <div>
            <section className='resume-custom'>
                <div className='container-custom'>
                    <div className='icon-container-custom' style={{ backgroundColor: '#E3FCEE', color: '#1E9E5E' }}>
                        <RiMoneyDollarCircleLine />
                    </div>
                    <div>
                        <h5 className="text-base font-semibold">Ganancias</h5>
                        <h3 className="text-xl font-bold ">$1000</h3>
                        <h6 className="text-sm">$50 en el útlimo mes</h6>
                    </div>
                </div>
                <div className='container-custom'>
                    <div className='icon-container-custom' style={{ backgroundColor: '#CFF4FE', color: '#326C92' }}>
                        <FaPiggyBank />
                    </div>
                    <div>
                    <h5 className="text-base font-semibold">Ganancias</h5>
                        <h3 className="text-xl font-bold ">$1000</h3>
                        <h6 className="text-sm">$50 en el útlimo mes</h6>
                    </div>
                </div>
                <div className='container-custom'>
                    <div className='icon-container-custom' style={{ backgroundColor: '#FECAF2', color: '#E76899' }}>
                        <FaShoppingCart />
                    </div>
                    <div>
                    <h5 className="text-base font-semibold">Ganancias</h5>
                        <h3 className="text-xl font-bold ">$1000</h3>
                        <h6 className="text-sm">$50 en el útlimo mes</h6>
                    </div>
                </div>
            </section>

            <section className='details-custom'>
                <div className='grafict-custom' id='grafict'>
                    Informe de ventas por año
                </div>
                <div className='clients-custom'>Porcentaje de clientes</div>
                <div className='products-custom'>Historial de productos Vendidos</div>
            </section>
        </div>
    )
}
