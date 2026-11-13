import React, { useState } from "react";
import {
  LiquidNavbar,
  NimbusIcons,
  type LiquidNavItem,
} from "./liquid-glass-navbar";

const navItems: LiquidNavItem[] = [
  { label: "Generate Bill", icon: NimbusIcons.bolt, fx: "glow" },
  { label: "Tariff Calc", icon: NimbusIcons.globe, fx: "spin" },
  { label: "Billing Guide", icon: NimbusIcons.drop, fx: "drop" },
  { label: "About VoltEdge", icon: NimbusIcons.home, fx: "pop" },
];

export function LiquidNavbarDemo() {
  const [active, setActive] = useState(0);

  return (
    <div className="flex flex-col items-center justify-center min-h-[220px] p-6 bg-slate-900 rounded-2xl text-white">
      <LiquidNavbar
        items={navItems}
        active={active}
        onChange={(idx) => setActive(idx)}
        tone="dark"
        sound={true}
      />
      <p className="mt-4 text-xs text-slate-400">
        Active tab: {navItems[active]?.label}
      </p>
    </div>
  );
}

export default LiquidNavbarDemo;

